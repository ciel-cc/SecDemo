package com.secshow.demo.service;

import com.secshow.demo.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> allCategory();

    Integer addCategory(Category category);

    Integer updateCategory(Category category);

    Integer deleteCategory(Integer cateId);

}
