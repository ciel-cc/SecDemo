package com.secshow.demo.controller;

import com.secshow.demo.model.Category;
import com.secshow.demo.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("cate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping("allCate")
    public List<Category> allCate(){
        return categoryService.allCategory();
    }
}
