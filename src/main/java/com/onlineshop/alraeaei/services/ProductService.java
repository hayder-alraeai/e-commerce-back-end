package com.onlineshop.alraeaei.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineshop.alraeaei.dtos.ProductDTO;
import com.onlineshop.alraeaei.models.Product;
import com.onlineshop.alraeaei.repositories.CategoryRepository;
import com.onlineshop.alraeaei.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class ProductService {
    private final PhotoService photoService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(String productId){
        return productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This product is not found!"));
    }
    public Product addProduct(String categoryId, String productDescription, MultipartFile image, double productPrice) throws IOException {
        Product product = new Product();
        product.setCategory(categoryRepository.findById(categoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This category is not found!")));
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);
        product.setImageId(photoService.saveImage(image));
        return productRepository.save(product);
    }
    public Product updateProduct(String categoryId, String productDescription, MultipartFile image, double productPrice, String productId) throws IOException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product is not found!"));
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);
        product.setCategory(categoryRepository.getOne(categoryId));
        if (image != null ){
            product.setImageId(photoService.updateImage(product.getImageId(), image));
        }
        return productRepository.save(product);
    }
    public void deleteProduct(String productId){
        photoService.deleteImage(productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Image is not found!")).getImageId());
        productRepository.deleteById(productId);
    }

    public List<Product> getProductsByCategoryId(String categoryId) {
        return productRepository.findAll().stream()
                .filter(product -> product.getCategory().getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }
}
