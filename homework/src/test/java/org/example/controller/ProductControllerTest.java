package org.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.example.DTO.ProductDTO;
import org.example.exception.InvalidProductRequestException;
import org.example.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

  private static final Long PRODUCT_ID = 1L;
  private static final ProductDTO PRODUCT_DTO = new ProductDTO();
  private static final ProductDTO REQUEST = new ProductDTO();
  private static final ProductDTO CREATED_PRODUCT = new ProductDTO();

  private static final String OBJECT_NAME = "objectName";
  private static final String FIELD = "field";
  private static final String DEFAULT_MESSAGE = "defaultMessage";
  private static final FieldError FIELD_ERROR = new FieldError(OBJECT_NAME, FIELD, DEFAULT_MESSAGE);
  private static final List<FieldError> FIELD_ERROR_LIST = List.of(FIELD_ERROR);

  private static final String ERROR_MESSAGE = FIELD + " - " + DEFAULT_MESSAGE;

  @Mock
  private ProductService productService;

  @Mock
  private BindingResult bindingResult;

  private ProductController underTest;

  @BeforeEach
  public void setUp() {
    underTest = new ProductController(productService);
  }

  @Test
  public void testFindAllShouldReturnListOfProducts() {
    // given
    List<ProductDTO> productDTOList = Collections.singletonList(PRODUCT_DTO);

    given(productService.findAll()).willReturn(productDTOList);

    // when
    ResponseEntity<List<ProductDTO>> result = underTest.findAll();

    // then
    ResponseEntity<List<ProductDTO>> expected = ResponseEntity.ok().body(productDTOList);

    assertEquals(expected, result);
  }

  @Test
  public void testFindByIdShouldReturnProductWhenItExists() {
    // given
    Optional<ProductDTO> productDTOOptional = Optional.of(PRODUCT_DTO);

    given(productService.findById(PRODUCT_ID)).willReturn(productDTOOptional);

    // when
    ResponseEntity<ProductDTO> result = underTest.findById(PRODUCT_ID);

    // then
    ResponseEntity<ProductDTO> expected = ResponseEntity.ok(PRODUCT_DTO);

    assertEquals(expected, result);
  }

  @Test
  public void testFindByIdShouldReturnNotFoundWhenProductDoesNotExist() {
    // given
    given(productService.findById(PRODUCT_ID)).willReturn(Optional.empty());

    // when
    ResponseEntity<ProductDTO> result = underTest.findById(PRODUCT_ID);

    // then
    ResponseEntity<ProductDTO> expected = ResponseEntity.notFound().build();

    assertEquals(expected, result);
  }

  @Test
  public void testCreateShouldCreateAndReturnNewProductWhenRequestIsValid() {
    // given
    given(productService.create(REQUEST)).willReturn(CREATED_PRODUCT);

    // when
    ResponseEntity<ProductDTO> result = underTest.create(REQUEST, bindingResult);

    // then
    ResponseEntity<ProductDTO> expected = ResponseEntity.status(HttpStatus.CREATED)
            .body(CREATED_PRODUCT);

    assertEquals(expected, result);
  }

  @Test
  public void testCreateShouldThrowExceptionWhenRequestIsInvalid() {
    // given
    given(bindingResult.hasErrors()).willReturn(true);
    given(bindingResult.getFieldErrors()).willReturn(FIELD_ERROR_LIST);

    // when
    InvalidProductRequestException thrownException = null;

    try {
      underTest.create(REQUEST, bindingResult);
    } catch (InvalidProductRequestException e) {
      thrownException = e;
    }

    // then
    assertNotNull(thrownException);
    assertEquals(Collections.singletonList(ERROR_MESSAGE), thrownException.getErrors());
  }

  @Test
  public void testDeleteShouldDeleteTheRequestedProduct() {
    // given in setup

    // when
    ResponseEntity<Void> result = underTest.delete(PRODUCT_ID);

    // then
    ResponseEntity<Void> expected = ResponseEntity.noContent().build();

    verify(productService).delete(PRODUCT_ID);
    assertEquals(expected, result);
  }

}
