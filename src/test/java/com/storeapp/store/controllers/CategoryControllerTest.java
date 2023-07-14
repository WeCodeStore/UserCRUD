package com.storeapp.store.controllers;

import com.storeapp.store.repository.CategoryRepository;
import com.storeapp.store.services.CategoryService;
import com.storeapp.store.utils.TestData;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    CategoryController catController;

    @Test
    void getAllAddressesTest() {
        var expected = TestData.categoryDTOList;
        Mockito.when(categoryService.getAllCategories()).thenReturn(expected);
        var actual = catController.getAllCategories();
        assertEquals(expected.get(0).getName(), actual.getBody().get(0).getName());
    }

}
