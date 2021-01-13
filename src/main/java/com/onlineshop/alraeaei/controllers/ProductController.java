package com.onlineshop.alraeaei.controllers;

import com.onlineshop.alraeaei.dtos.ProductDTO;
import com.onlineshop.alraeaei.models.Product;
import com.onlineshop.alraeaei.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") String productId){
        return productService.getProduct(productId);
    }
    @PostMapping
    public Product addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }
    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("productId") String productId){
        return productService.updateProduct(productDTO, productId);
    }
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") String productId){
        productService.deleteProduct(productId);
    }
}
