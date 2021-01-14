package com.onlineshop.alraeaei.repositories;

import com.onlineshop.alraeaei.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
