package com.storeapp.store.services;

import com.storeapp.store.models.Product;
import com.storeapp.store.models.ProductDTO;
import com.storeapp.store.repository.ProductRepository;
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

    public ProductDTO getProductById(long productId) {
        var product = productRepository.findByProductId(productId);
        return modelMapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> getProductsByCategoryId (long categoryId) {
        var productList = new ArrayList<ProductDTO>();
        var list = productRepository.findAllByCategoryId(categoryId);
        for (Product product: list) {
            productList.add(modelMapper.map(product, ProductDTO.class));
        }
        return productList;
    }
}
