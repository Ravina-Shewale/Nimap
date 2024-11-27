package com.example.service.impl;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Category> category = categoryRepository.findById(product.getCategory().getId());
        category.ifPresent(product::setCategory);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
