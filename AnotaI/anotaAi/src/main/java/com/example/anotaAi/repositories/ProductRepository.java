package com.example.anotaAi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.anotaAi.domain.product.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
