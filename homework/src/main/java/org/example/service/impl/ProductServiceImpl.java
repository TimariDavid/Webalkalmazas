package org.example.service.impl;

import org.example.DTO.ProductDTO;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .map(movie -> modelMapper.map(movie, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id)
                .map(m -> modelMapper.map(m, ProductDTO.class));
    }

    @Override
    public Optional<ProductDTO> findByType(String type) {
        return productRepository.
    }

    @Override
    public ProductDTO create(ProductDTO movieDTO) {
        movieDTO.setId(null);

        Product movieToSave = modelMapper.map(movieDTO, Product.class);
        Product savedMovie = productRepository.save(movieToSave);

        return modelMapper.map(savedMovie, ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        Optional<Product> movieToDelete = productRepository.findById(id);

        if (movieToDelete.isPresent()) {
            productRepository.delete(movieToDelete.get());
        } else {
            throw new MovieNotFoundException("Movie not found with id=" + id);
        }
    }

}
