package com.storeapp.store.services;

import com.storeapp.store.models.Category;
import com.storeapp.store.models.CategoryDTO;
import com.storeapp.store.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<CategoryDTO> getAllCategories() {
        var catList = new ArrayList<CategoryDTO>();
        var list = categoryRepository.findAll();
        for (Category category : list) {
            catList.add(modelMapper.map(category, CategoryDTO.class));
        }
        return catList;
    }
}
