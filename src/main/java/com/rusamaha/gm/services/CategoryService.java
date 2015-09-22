package com.rusamaha.gm.services;

import com.rusamaha.gm.dao.CategoryRepository;
import com.rusamaha.gm.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
* Created by Mary on 22.02.2015.
*/
@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository category;

    public Iterable<Category> getAllCategories(){
        return category.findAll();
    }
}

