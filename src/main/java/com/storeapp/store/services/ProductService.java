package com.storeapp.store.services;

import com.storeapp.store.models.Product;
import com.storeapp.store.repository.ProductRepository;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long productId) {
        return productRepository.findByProductId(productId);
    }

    public List<Product> getProductsByCategoryId (long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }
}
