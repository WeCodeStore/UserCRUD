package com.storeapp.store.controllers;

import com.storeapp.store.models.Product;
import com.storeapp.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategoryId(@PathVariable long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
