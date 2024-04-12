package com.example.anotaAi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.anotaAi.domain.product.Product;
import com.example.anotaAi.domain.product.ProductDTO;
import com.example.anotaAi.domain.product.exceptions.ProductNotFoundException;
import com.example.anotaAi.repositories.CategoryRepository;
import com.example.anotaAi.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public Product insert(ProductDTO ProductData) {
        Product newProduct = new Product(ProductData);
        this.repository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAll() {
        return this.repository.findAll();
    }

    public Product update(ProductDTO ProductData, String id) throws ProductNotFoundException {

        Product newProduct = this.repository.findById(id).orElseThrow(ProductNotFoundException::new);

        if (!ProductData.title().isEmpty())
            newProduct.setTitle(ProductData.title());
        if (!ProductData.description().isEmpty())
            newProduct.setDescription(ProductData.description());

        this.repository.save(newProduct);

        return newProduct;
    }

    public void delete(String id) throws ProductNotFoundException {
        Product newProduct = this.repository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.repository.delete(newProduct);
    }
}
