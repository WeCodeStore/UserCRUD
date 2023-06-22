package com.storeapp.store.services;

import com.storeapp.store.models.CategoryDTO;
import com.storeapp.store.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.storeapp.store.utils.TestData.categoryList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @Test
    public void testGetAllCategory() {
        when(categoryRepository.findAll()).thenReturn(categoryList);
        List <CategoryDTO> result = categoryService.getAllCategories();
        assertEquals(categoryList.size(), result.size());
    }
    @Test
    public void testGetAllCategoryReturnNull() {
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());
        List <CategoryDTO> result = categoryService.getAllCategories();
        assertEquals(0, result.size());
    }


}
