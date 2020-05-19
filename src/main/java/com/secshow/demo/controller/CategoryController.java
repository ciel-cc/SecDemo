package com.secshow.demo.controller;

import com.secshow.demo.model.Category;
import com.secshow.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("addCate")
    public String addCate(@RequestBody Category category){
        int res = categoryService.addCategory(category);
        if (res == 1)
            return "success";
        return "false";
    }

    @RequestMapping("updateCate")
    public String update(@RequestBody Category category){
        int res = categoryService.updateCategory(category);
        if (res == 1)
            return "success";
        return "false";
    }

    @RequestMapping("delCate/{cateId}")
    public String del(@PathVariable Integer cateId){
        int res = categoryService.deleteCategory(cateId);
        if (res == 1)
            return "success";
        return "false";
    }
}
