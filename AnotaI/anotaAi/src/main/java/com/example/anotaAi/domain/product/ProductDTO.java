package com.example.anotaAi.domain.product;

import com.example.anotaAi.domain.category.Category;

public record ProductDTO(String title, String description, String ownerId, Integer price, Category category) {

}
