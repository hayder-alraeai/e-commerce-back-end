package com.onlineshop.alraeaei.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineshop.alraeaei.dtos.CategoryDTO;
import com.onlineshop.alraeaei.models.Category;
import com.onlineshop.alraeaei.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ObjectMapper objectMapper;
    private final ProductService productService;


    public List<Category> getCategories(){
       return categoryRepository.findAll();
    }
    public Category getCategory(String categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This category is not found!"));
    }
    public Category addCategory(CategoryDTO categoryDTO){
        System.out.println(categoryDTO.getCategoryName());
        Category category = objectMapper.convertValue(categoryDTO, Category.class);
        return categoryRepository.save(category);
    }
    public Category updateCategory(CategoryDTO categoryDTO, String categoryId){
        Category category = categoryRepository.getOne(categoryId);
        category = objectMapper.convertValue(categoryDTO, Category.class);
        category.setCategoryId(categoryId);
        return categoryRepository.save(category);
    }
    public void deleteCategory(String categoryId){
        if (!productService.getProductsByCategoryId(categoryId).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This category cannot be deleted! Move items in this category to another category first!");
        }
        categoryRepository.deleteById(categoryId);
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findAll().stream().filter( category -> category.getCategoryName().equals(categoryName))
                .findAny().get();
    }
}
