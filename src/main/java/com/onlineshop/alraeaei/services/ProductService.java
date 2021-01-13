package com.onlineshop.alraeaei.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineshop.alraeaei.dtos.ProductDTO;
import com.onlineshop.alraeaei.models.Product;
import com.onlineshop.alraeaei.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public ProductService(ProductRepository productRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(String productId){
        return productRepository.findById(productId).orElseThrow();
    }
    public Product addProduct(ProductDTO productDTO){
        Product product = objectMapper.convertValue(productDTO, Product.class);
        product.setId(UUID.randomUUID().toString());
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
