package com.onlineshop.alraeaei.repositories;

import com.onlineshop.alraeaei.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, String> {
}
