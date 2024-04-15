package com.example.anotaAi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.anotaAi.domain.category.Category;
import com.example.anotaAi.domain.product.Product;
import com.example.anotaAi.domain.product.ProductDTO;
import com.example.anotaAi.domain.product.exceptions.ProductNotFoundException;
import com.example.anotaAi.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Product insert(ProductDTO productData) {
        Optional<Category> category = this.categoryService.findById(productData.category().getId());

        Product newProduct = new Product(productData);
        newProduct.setCategory(category.get());
        this.productRepository.save(newProduct);
        return newProduct;
    }

    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    public Product update(ProductDTO productData, String id) throws ProductNotFoundException {

        Product newProduct = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        if (productData.category().getId() != null)
            this.categoryService.findById(productData.category().getId())
                    .ifPresent(newProduct::setCategory);

        if (!productData.title().isEmpty())
            newProduct.setTitle(productData.title());
        if (!productData.description().isEmpty())
            newProduct.setDescription(productData.description());
        if (productData.price() == null)
            newProduct.setPrice(productData.price());

        this.productRepository.save(newProduct);

        return newProduct;
    }

    public void delete(String id) throws ProductNotFoundException {
        Product newProduct = this.productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.productRepository.delete(newProduct);
    }
}
