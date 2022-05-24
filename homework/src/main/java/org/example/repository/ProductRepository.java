package org.example.repository;

import org.example.DTO.ProductDTO;
import org.example.entity.Product;
import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByType(String type);

}
