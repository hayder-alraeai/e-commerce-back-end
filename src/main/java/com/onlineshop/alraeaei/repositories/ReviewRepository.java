package com.onlineshop.alraeaei.repositories;

import com.onlineshop.alraeaei.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
     List<Review> findReviewByProductId(String productId);
}
