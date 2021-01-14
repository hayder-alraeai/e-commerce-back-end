package com.onlineshop.alraeaei.controllers;

import com.onlineshop.alraeaei.dtos.ProductDTO;
import com.onlineshop.alraeaei.models.Category;
import com.onlineshop.alraeaei.models.Product;
import com.onlineshop.alraeaei.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
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
    public Product addProduct(@RequestParam("image") MultipartFile image,
                              @RequestParam("categoryId") String categoryId,
                              @RequestParam("productDescription") String productDescription,
                              @RequestParam("productPrice") double productPrice) throws IOException {
        return productService.addProduct(categoryId, productDescription, image, productPrice);
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
