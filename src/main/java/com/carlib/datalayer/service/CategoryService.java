package com.carlib.datalayer.service;

import com.carlib.datalayer.model.Category;
import com.carlib.datalayer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * @return a list of Categories
     * */
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    /**
     * @return one Category relative to its id
     * */
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    /**
     * @param category
     * @return a new object of Class Category
     * */
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

}
