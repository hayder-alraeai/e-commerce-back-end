package com.onlineshop.alraeaei.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineshop.alraeaei.dtos.ProductDTO;
import com.onlineshop.alraeaei.models.Product;
import com.onlineshop.alraeaei.repositories.CategoryRepository;
import com.onlineshop.alraeaei.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private final PhotoService photoService;
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, CategoryRepository categoryRepository, CategoryService categoryService1,  PhotoService photoService, ObjectMapper objectMapper, CategoryRepository categoryRepository1) {
        this.productRepository = productRepository;
        this.photoService = photoService;
        this.objectMapper = objectMapper;
        this.categoryRepository = categoryRepository1;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(String productId){
        return productRepository.findById(productId).orElseThrow();
    }
    public Product addProduct(String categoryId, String productDescription, MultipartFile image, double productPrice) throws IOException {
        Product product = new Product();
        product.setCategory(categoryRepository.findById(categoryId).orElseThrow());
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);
        product.setImageId(photoService.saveImage(image));
        return productRepository.save(product);
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
