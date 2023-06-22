package com.storeapp.store.controllers;

import com.storeapp.store.services.ProductService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class ProductControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    @Test
    void getAllProductsTest() {
        var expected = TestData.productDtoList;
        Mockito.when(productService.getAllProducts()).thenReturn(expected);
        var actual = productController.getAllProducts();
        assertEquals(expected.get(0).getCategory(), actual.get(0).getCategory());
    }

    @Test
    void getProductByIdTest() {
        var expected = TestData.productDTO;
        Mockito.when(productService.getProductById(anyLong())).thenReturn(expected);
        var actual = productController.getProductById(1L);
        assertEquals(expected.getCategory(), actual.getCategory());
    }

    @Test
    void getProductsByCategory() {
        var expected = TestData.productDtoList;
        Mockito.when(productService.getProductsByCategoryId(anyLong())).thenReturn(expected);
        var actual = productController.getProductsByCategoryId(1L);
        assertEquals(expected.get(0).getCategory(), actual.get(0).getCategory());
    }

}
