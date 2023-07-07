package com.storeapp.store.services;

import com.storeapp.store.models.PageOfProductsDTO;
import com.storeapp.store.models.Product;
import com.storeapp.store.models.ProductDTO;
import com.storeapp.store.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public PageOfProductsDTO<List<ProductDTO>> getProductByPage(int pageNum, int pageSize) {
        // Paging properties
        Pageable paging = PageRequest.of(pageNum, pageSize);
        // Fetching data from repository as pageable
        Page<Product> pageOfProduct = productRepository.findAll(paging);
        return pagination(pageOfProduct);
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

    private PageOfProductsDTO<List<ProductDTO>> pagination(Page<Product> pageOfProduct) {
        PageOfProductsDTO<List<ProductDTO>> productByPage = new PageOfProductsDTO<List<ProductDTO>>();

        productByPage.setProducts(productMapToDTO(pageOfProduct.getContent()));
        productByPage.setHasNext(pageOfProduct.hasNext());
        productByPage.setTotalElements(pageOfProduct.getTotalElements());
        return productByPage;
    }

    private List<ProductDTO> productMapToDTO(List<Product> products) {
        var productDTOList = new ArrayList<ProductDTO>();
        for (Product product : products) {
            productDTOList.add(modelMapper.map(product, ProductDTO.class));
        }
        return productDTOList;
    }
}
