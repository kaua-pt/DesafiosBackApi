package com.example.anotaAi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.anotaAi.domain.product.Product;
import com.example.anotaAi.domain.product.ProductDTO;
import com.example.anotaAi.domain.product.exceptions.ProductNotFoundException;
import com.example.anotaAi.services.ProductService;

public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO ProductData) {
        Product newProduct = this.service.insert(ProductData);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody ProductDTO ProductData, @PathVariable String id) {
        try {
            Product updatedProduct = this.service.update(ProductData, id);
            return ResponseEntity.ok().body(updatedProduct);
        } catch (ProductNotFoundException e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable String id) {
        try {
            this.service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return null;
        }
    }

}
