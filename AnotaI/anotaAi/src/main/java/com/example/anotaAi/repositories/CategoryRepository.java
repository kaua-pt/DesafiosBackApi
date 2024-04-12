package com.example.anotaAi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.anotaAi.domain.category.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
