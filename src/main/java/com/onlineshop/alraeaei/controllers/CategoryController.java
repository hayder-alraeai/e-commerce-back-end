package com.onlineshop.alraeaei.controllers;

import com.onlineshop.alraeaei.dtos.CategoryDTO;
import com.onlineshop.alraeaei.models.Category;
import com.onlineshop.alraeaei.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") String categoryId){
        return categoryService.getCategory(categoryId);
    }
    @PostMapping
    public Category addCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }
    @PutMapping("/{categoryId}")
    public Category updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable("categoryId") String categoryId){
        return categoryService.updateCategory(categoryDTO, categoryId);
    }
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") String categoryId){
        categoryService.deleteCategory(categoryId);
    }
    @GetMapping("/name/{categoryName}")
    public Category getCategoriesByName(@PathVariable("categoryName") String categoryName){
        return categoryService.getCategoryByName(categoryName);
    }
}
