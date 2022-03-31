package org.example.service;

import org.example.DTO.ProductDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDTO> findAll();

    Optional<ProductDTO> findById(Long id);

    @Query("SELECT * FROM Product u WHERE u.type = :type")
    Optional<ProductDTO> findByType(String type);

    ProductDTO create(ProductDTO productDTO);

    void delete(Long id);

}
