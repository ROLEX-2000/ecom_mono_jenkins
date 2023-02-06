package com.project.ecom.controller;


import org.springframework.web.bind.annotation.*;

import com.project.ecom.model.Product;
import com.project.ecom.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts() {

        return productService.getAllProducts();

    }

    @PostMapping()
    public void addProduct(@RequestBody Product product) {

        productService.addProduct(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id) {

        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") int id, @RequestBody Product product) {

        productService.updateProduct(id, product);
        return "Product is updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") int id) {

        productService.deleteProductById(id);

        return "Product is deleted.";
    }
}
