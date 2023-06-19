package com.storeapp.store.controllers;

import com.storeapp.store.models.Category;
import com.storeapp.store.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("store/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
