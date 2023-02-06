package com.project.ecom.service;


import org.springframework.stereotype.Service;

import com.project.ecom.model.Product;
import com.project.ecom.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {

        productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {

        return productRepository.findById(id);
    }

    public void updateProduct(int id, Product product) {

        productRepository.save(product);
    }

    public void deleteProductById(int id) {

        productRepository.deleteById(id);
    }
}
