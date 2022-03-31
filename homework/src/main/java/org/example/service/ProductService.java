package org.example.service;

public class ProductService {

    List<ProductDTO> findAll();

    Optional<ProductDTO> findById();

    Optional<ProductDTO> findbByType();

    ProductDTO create();

    void delete();

}
