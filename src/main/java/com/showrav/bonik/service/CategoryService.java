package com.showrav.bonik.service;

import com.showrav.bonik.domain.Category;

import java.util.List;


public interface CategoryService {

    void save(Category category);
    List<Category> findAll();
}
