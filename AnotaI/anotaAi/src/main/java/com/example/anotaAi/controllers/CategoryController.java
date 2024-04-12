package com.example.anotaAi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anotaAi.domain.category.Category;
import com.example.anotaAi.domain.category.CategoryDTO;
import com.example.anotaAi.domain.category.exceptions.CategoryNotFoundException;
import com.example.anotaAi.services.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryData) {
        Category newCategory = this.service.insert(categoryData);
        return ResponseEntity.ok().body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = this.service.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@RequestBody CategoryDTO categoryData, @PathVariable String id) {
        try {
            Category updatedCategory = this.service.update(categoryData, id);
            return ResponseEntity.ok().body(updatedCategory);
        } catch (CategoryNotFoundException e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable String id) {
        try {
            this.service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return null;
        }
    }
}
