package com.secshow.demo.service.impl;

import com.secshow.demo.mapper.CategoryMapper;
import com.secshow.demo.model.Category;
import com.secshow.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> allCategory() {
        return categoryMapper.selectAll();
    }

    @Override
    public Integer addCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public Integer updateCategory(Category category) {
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public Integer deleteCategory(Integer cateId) {
        return categoryMapper.deleteByPrimaryKey(cateId);
    }
}
