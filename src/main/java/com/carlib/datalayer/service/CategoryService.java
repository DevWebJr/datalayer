package com.carlib.datalayer.service;

import com.carlib.datalayer.model.Category;
import com.carlib.datalayer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
