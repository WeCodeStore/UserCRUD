package com.storeapp.store.services;

import com.storeapp.store.models.PageOfProductsDTO;
import com.storeapp.store.models.Product;
import com.storeapp.store.models.ProductDTO;
import com.storeapp.store.repository.ProductRepository;
import com.storeapp.store.repository.ReviewRepository;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    ReviewRepository reviewRep;

    @InjectMocks
    ProductService productService;

    @Test
    void getAllProductsTest() {
        Mockito.when(productRepository.findAll()).thenReturn(TestData.productList);
        Mockito.when(reviewRep.findByProductId(anyLong())).thenReturn(TestData.reviewList);
        var actual = productService.getAllProducts();
        assertEquals("Chemical", actual.get(0).getName());
        assertThat(actual.get(0)).isInstanceOf(ProductDTO.class);
    }

    @Test
    void getProductByPageSucessTest() throws Exception {
        List<Product> testList = TestData.productList;
        Page<Product> pageOfProducts = new PageImpl<>(testList.subList(0, 1));
        Mockito.when(productRepository.findAll((Pageable) any())).thenReturn(pageOfProducts);
        Mockito.when(reviewRep.findByProductId(anyLong())).thenReturn(TestData.reviewList);
        PageOfProductsDTO<List<ProductDTO>> productPage = productService.getProductByPage(0, 1);
        assertEquals(1L, productPage.getTotalElements(), "test");
    }

    @Test
    void getProductByCategoryByPageSucessTest() throws Exception {
        List<Product> testList = TestData.productList;
        Page<Product> pageOfProducts = new PageImpl<>(testList.subList(0, 1));
        Mockito.when(productRepository.findAllByCategoryId(anyLong(),(Pageable) any())).thenReturn(pageOfProducts);
        Mockito.when(reviewRep.findByProductId(anyLong())).thenReturn(TestData.reviewList);
        PageOfProductsDTO<List<ProductDTO>> productPage = productService.getProductByCategoryByPage(1, 0, 1);
        assertEquals(1L, productPage.getTotalElements(), "test");
    }

    @Test
    void getProductByIdTest() {
        Mockito.when(productRepository.findByProductId(anyLong())).thenReturn(TestData.product);
        Mockito.when(reviewRep.findByProductId(anyLong())).thenReturn(TestData.reviewList);
        var actual = productService.getProductById(1L);
        assertEquals("Chemical", actual.getName());
        assertThat(actual).isInstanceOf(ProductDTO.class);
    }

    @Test
    void getProductsByCategoryId() {
        Mockito.when(productRepository.findAllByCategoryId(anyLong())).thenReturn(TestData.productList);
        Mockito.when(reviewRep.findByProductId(anyLong())).thenReturn(TestData.reviewList);
        var actual = productService.getProductsByCategoryId(1L);
        assertEquals("Chemical", actual.get(0).getName());
        assertThat(actual.get(0)).isInstanceOf(ProductDTO.class);
    }

}
