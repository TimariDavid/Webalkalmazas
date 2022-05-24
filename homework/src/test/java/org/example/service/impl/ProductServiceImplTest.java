package org.example.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.example.DTO.ProductDTO;
import org.example.entity.Product;
import org.example.exception.ProductNotFoundException;
import org.example.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

  private static final Long PRODUCT_ID = 1L;

  private static final Product PRODUCT = new Product();
  private static final ProductDTO PRODUCT_DTO = new ProductDTO();

  @Mock
  private ProductRepository productRepository;
  @Mock
  private ModelMapper modelMapper;

  private ProductServiceImpl underTest;

  @BeforeEach
  public void setUp() {
    underTest = new ProductServiceImpl(productRepository, modelMapper);
  }

  @Test
  public void testFindAllShouldReturnAllProducts() {
    // given
    given(productRepository.findAll()).willReturn(Collections.singletonList(PRODUCT));
    given(modelMapper.map(PRODUCT, ProductDTO.class)).willReturn(PRODUCT_DTO);

    // when
    List<ProductDTO> result = underTest.findAll();

    // then
    List<ProductDTO> expected = Collections.singletonList(PRODUCT_DTO);

    assertEquals(expected, result);
  }

  @Test
  public void testFindByIdShouldReturnProductInOptionalWhenItExists() {
    // given
    given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.of(PRODUCT));
    given(modelMapper.map(PRODUCT, ProductDTO.class)).willReturn(PRODUCT_DTO);

    // when
    Optional<ProductDTO> result = underTest.findById(PRODUCT_ID);

    // then
    Optional<ProductDTO> expected = Optional.of(PRODUCT_DTO);

    assertEquals(expected, result);
  }

  @Test
  public void testFindByIdShouldReturnEmptyOptionalWhenProductNotFound() {
    // given
    given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.empty());

    // when
    Optional<ProductDTO> result = underTest.findById(PRODUCT_ID);

    // then
    Optional<ProductDTO> expected = Optional.empty();

    assertEquals(expected, result);
  }


  @Test
  public void testDeleteShouldDeleteRequestedProduct() {
    // given
    Product productToDelete = new Product();
    productToDelete.setId(PRODUCT_ID);
    Optional<Product> productToDeleteOptional = Optional.of(productToDelete);

    given(productRepository.findById(PRODUCT_ID)).willReturn(productToDeleteOptional);

    // when
    underTest.delete(PRODUCT_ID);

    // then
    verify(productRepository).delete(productToDelete);
  }

  @Test
  public void testDeleteShouldThrowExceptionWhenProductNotFound() {
    // given
    given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.empty());

    // when - then
    assertThrows(ProductNotFoundException.class, () -> {
      underTest.delete(PRODUCT_ID);
    });
  }

}
