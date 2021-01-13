package com.onlineshop.alraeaei.repositories;

import com.onlineshop.alraeaei.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
