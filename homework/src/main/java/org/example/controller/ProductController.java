package org.example.controller;

import org.example.DTO.ProductDTO;
import org.example.exception.InvalidProductRequestException;
import org.example.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> products = productService.findAll();

        return ResponseEntity.ok().body(products);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Optional<ProductDTO> product = productService.findById(id);

        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/type/{type}")
    public ResponseEntity<List<ProductDTO>> findByType(@PathVariable String type) {
        List<ProductDTO> product = productService.findByType(type);

        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        checkForRequestErrors(bindingResult);

        ProductDTO savedProduct = productService.create(productDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedProduct);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }

    private void checkForRequestErrors(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> messages = bindingResult.getFieldErrors()
                    .stream()
                    .map(this::fieldErrorToMessage)
                    .collect(Collectors.toList());

            throw new InvalidProductRequestException("Invalid product request", messages);
        }
    }

    private String fieldErrorToMessage(FieldError fieldError) {
        return fieldError.getField() + " - " + fieldError.getDefaultMessage();
    }

}
