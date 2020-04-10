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
}
