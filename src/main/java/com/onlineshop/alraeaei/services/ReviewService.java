package com.onlineshop.alraeaei.services;

import com.onlineshop.alraeaei.dtos.ReviewDTO;
import com.onlineshop.alraeaei.models.Product;
import com.onlineshop.alraeaei.models.Review;
import com.onlineshop.alraeaei.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    ReviewRepository reviewRepository;

    public Review createReview(ReviewDTO reviewDTO) {
        return reviewRepository.save(new Review(reviewDTO.getProductId(),
                reviewDTO.getName(),
                reviewDTO.getComment(),
                reviewDTO.getRate()));
    }

    public List<Review> getReviewsByProductId(String productId) {
        return reviewRepository.findReviewByProductId(productId);
    }
    public void deleteAllByProductId(String productId){
        reviewRepository.deleteAll(getReviewsByProductId(productId));
    }
    public void deleteById(String id){
        reviewRepository.deleteById(id);
    }
}
