package com.storeapp.store.services;

import com.storeapp.store.models.Product;
import com.storeapp.store.models.ProductDTO;
import com.storeapp.store.repository.ProductRepository;
import org.hibernate.grammars.hql.HqlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<ProductDTO> getAllProducts() {
        var productList = new ArrayList<ProductDTO>();
        var list = productRepository.findAll();
        for (Product product: list) {
            productList.add(modelMapper.map(product, ProductDTO.class));
        }
        return productList;
    }

    public Product getProductById(long productId) {
        return productRepository.findByProductId(productId);
    }

    public List<Product> getProductsByCategoryId (long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }
}
