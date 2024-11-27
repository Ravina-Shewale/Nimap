package com.example.service;

import com.example.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);

    Product createProduct(Product product);

    Optional<Product> getProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
