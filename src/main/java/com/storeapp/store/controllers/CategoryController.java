package com.storeapp.store.controllers;

import com.storeapp.store.models.CategoryDTO;
import com.storeapp.store.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        var categories = categoryService.getAllCategories();
        if (categories == null || categories.size() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(categories);
    }
}
