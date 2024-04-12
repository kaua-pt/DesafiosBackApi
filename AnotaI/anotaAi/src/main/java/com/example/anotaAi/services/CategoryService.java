package com.example.anotaAi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.anotaAi.domain.category.Category;
import com.example.anotaAi.domain.category.CategoryDTO;
import com.example.anotaAi.domain.category.exceptions.CategoryNotFoundException;
import com.example.anotaAi.repositories.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);
        this.repository.save(newCategory);
        return newCategory;
    }

    public List<Category> getAll() {
        return this.repository.findAll();
    }

    public Optional<Category> findById(String id) {
        return this.repository.findById(id);
    }

    public Category update(CategoryDTO categoryData, String id) throws CategoryNotFoundException {

        Category newCategory = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);

        if (!categoryData.title().isEmpty())
            newCategory.setTitle(categoryData.title());
        if (!categoryData.description().isEmpty())
            newCategory.setDescription(categoryData.description());

        this.repository.save(newCategory);

        return newCategory;
    }

    public void delete(String id) throws CategoryNotFoundException {
        Category newCategory = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        this.repository.delete(newCategory);
    }
}
