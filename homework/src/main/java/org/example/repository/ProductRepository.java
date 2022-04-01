package org.example.repository;

import org.example.DTO.ProductDTO;
import org.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<ProductDTO> findByType(String type);
}
