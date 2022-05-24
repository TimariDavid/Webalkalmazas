package org.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.example.exception.InvalidProductRequestException;
import org.example.exception.ProductNotFoundException;
import org.example.response.BadRequestError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class ProductControllerAdviceTest {

  private static final String EXCEPTION_MESSAGE = "exceptionMessage";

  private static final String ERROR_MESSAGE_1 = "errorMessage1";
  private static final String ERROR_MESSAGE_2 = "errorMessage2";
  private static final List<String> ERROR_MESSAGE_LIST = List.of(ERROR_MESSAGE_1, ERROR_MESSAGE_2);
  private static final InvalidProductRequestException INVALID_PRODUCT_REQUEST_EXCEPTION =
          new InvalidProductRequestException(EXCEPTION_MESSAGE, ERROR_MESSAGE_LIST);

  private static final ProductNotFoundException PRODUCT_NOT_FOUND_EXCEPTION =
          new ProductNotFoundException(EXCEPTION_MESSAGE);

  private ProductControllerAdvice underTest;

  @BeforeEach
  public void setUp() {
    underTest = new ProductControllerAdvice();
  }

  @Test
  public void testInvalidRequestHandlerShouldReturnBadRequestErrorWithErrorMessagesFromException() {
    // given in setup

    // when
    ResponseEntity<BadRequestError> result = underTest.invalidRequestHandler(INVALID_PRODUCT_REQUEST_EXCEPTION);

    // then
    ResponseEntity<BadRequestError> expected = ResponseEntity.badRequest()
            .body(new BadRequestError(ERROR_MESSAGE_LIST));

    assertEquals(expected, result);
  }

  @Test
  public void testProductNotFoundHandlerShouldReturnEmptyResponseWithNotFoundStatusCode() {
    // given in setup

    // when
    ResponseEntity<Void> result = underTest.productNotFoundHandler(PRODUCT_NOT_FOUND_EXCEPTION);

    // then
    ResponseEntity<Void> expected = ResponseEntity.notFound().build();

    assertEquals(expected, result);
  }

}
