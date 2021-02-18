package com.onlineshop.alraeaei.controllers;

import com.onlineshop.alraeaei.dtos.ReviewDTO;
import com.onlineshop.alraeaei.models.Review;
import com.onlineshop.alraeaei.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/reviews")
public class ReviewController {
    ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody ReviewDTO reviewDTO){
        System.out.println(reviewDTO.getName());
        return reviewService.createReview(reviewDTO);
    }
    @GetMapping("/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable("productId") String productId){
        return reviewService.getReviewsByProductId(productId);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id){
        reviewService.deleteById(id);
    }
}
