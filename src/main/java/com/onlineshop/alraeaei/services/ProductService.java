package com.onlineshop.alraeaei.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineshop.alraeaei.dtos.ProductDTO;
import com.onlineshop.alraeaei.models.Category;
import com.onlineshop.alraeaei.models.Product;
import com.onlineshop.alraeaei.repositories.CategoryRepository;
import com.onlineshop.alraeaei.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, CategoryRepository categoryRepository, CategoryService categoryService1, ObjectMapper objectMapper, CategoryRepository categoryRepository1) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
        this.categoryRepository = categoryRepository1;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(String productId){
        return productRepository.findById(productId).orElseThrow();
    }
    public Product addProduct(ProductDTO productDTO){
        Product product = objectMapper.convertValue(productDTO, Product.class);
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow();
        List<Product> productList = category.getProducts();
        productList.add(product);
        category.setProducts(productList);
        productRepository.save(product);
        categoryRepository.save(category);
        return product;
    }
    public Product updateProduct(ProductDTO productDTO, String productId){
        Product product = objectMapper.convertValue(productDTO, Product.class);
        product.setId(productId);
        return productRepository.save(product);
    }
    public void deleteProduct(String productId){
        productRepository.deleteById(productId);
    }
}
