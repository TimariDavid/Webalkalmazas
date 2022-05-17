package org.example.service.impl;

import org.example.DTO.ProductDTO;
import org.example.entity.Product;
import org.example.exception.ProductNotFoundException;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id)
                .map(m -> modelMapper.map(m, ProductDTO.class));
    }

    @Override
    public List<ProductDTO> findByType(String type) {
        return productRepository.findByType(type)
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        productDTO.setId(null);

        Product productToSave = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(productToSave);

        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Product> productToDelete = productRepository.findById(id);

        if (productToDelete.isPresent()) {
            productRepository.delete(productToDelete.get());
        } else {
            throw new ProductNotFoundException("Product not found with id=" + id);
        }
    }

}
