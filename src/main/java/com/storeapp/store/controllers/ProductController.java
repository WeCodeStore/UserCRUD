package com.storeapp.store.controllers;

import com.storeapp.store.models.Product;
import com.storeapp.store.models.ProductDTO;
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
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductDTO getProductById(@PathVariable long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductsByCategoryId(@PathVariable long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
}
