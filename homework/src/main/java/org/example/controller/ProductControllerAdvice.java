package org.example.controller;

import org.example.exception.InvalidProductRequestException;
import org.example.exception.ProductNotFoundException;
import org.example.response.BadRequestError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = ProductController.class)
public class ProductControllerAdvice {

    @ExceptionHandler(value = InvalidProductRequestException.class)
    public ResponseEntity<BadRequestError> invalidRequestHandler(InvalidProductRequestException invalidProductRequestException) {
        BadRequestError badRequestError = new BadRequestError(invalidProductRequestException.getErrors());

        return ResponseEntity.badRequest()
                .body(badRequestError);
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Void> productNotFoundHandler(ProductNotFoundException invalidProductRequestException) {
        return ResponseEntity.notFound().build();
    }

}
