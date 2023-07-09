package com.storeapp.store.services;

import com.storeapp.store.models.PageOfProductsDTO;
import com.storeapp.store.models.Product;
import com.storeapp.store.models.ProductDTO;
import com.storeapp.store.repository.ProductRepository;
import com.storeapp.store.repository.ReviewRepository;
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

    @Autowired
    ReviewRepository reviewRep;

    ModelMapper modelMapper = new ModelMapper();

    public List<ProductDTO> getAllProducts() {
        var list = productRepository.findAll();

        return productMapToDTO(list);
    }

    public PageOfProductsDTO<List<ProductDTO>> getProductByPage(int pageNum, int pageSize) {
        // Paging properties
        Pageable paging = PageRequest.of(pageNum, pageSize);
        // Fetching data from repository as pageable
        Page<Product> pageOfProduct = productRepository.findAll(paging);
        return pagination(pageOfProduct);
    }

    public PageOfProductsDTO<List<ProductDTO>> getProductByCategoryByPage(long categoryId, int pageNum, int pageSize) {
        // Paging properties
        Pageable paging = PageRequest.of(pageNum, pageSize);
        // Fetching data from repository as pageable
        Page<Product> pageOfProduct = productRepository.findAllByCategoryId(categoryId,paging);
        if (pageOfProduct == null){
            return null;
        }
        return pagination(pageOfProduct);
    }

    public ProductDTO getProductById(long productId) {
        var product = productRepository.findByProductId(productId);
        var tempProdDto = modelMapper.map(product, ProductDTO.class);
        var lstReview = reviewRep.findByProductId(product.getProductId());
        tempProdDto.setTotalReviews(lstReview.size());
        tempProdDto.setReviewRate(lstReview.stream().mapToDouble(d -> d.getRating())
                .average()
                .orElse(0.0));

        return tempProdDto;
    }

    public List<ProductDTO> getProductsByCategoryId (long categoryId) {
        var list = productRepository.findAllByCategoryId(categoryId);

        return productMapToDTO(list);
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

        for (Product product: products) {
            var tempProdDto=modelMapper.map(product, ProductDTO.class);
            var lstReview = reviewRep.findByProductId(product.getProductId());
            tempProdDto.setTotalReviews(lstReview.size());
            tempProdDto.setReviewRate(lstReview.stream().mapToDouble(d -> d.getRating())
                    .average()
                    .orElse(0.0));
            productDTOList.add(tempProdDto);
        }

        return productDTOList;
    }
}
