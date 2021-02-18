package com.onlineshop.alraeaei.repositories;

import com.onlineshop.alraeaei.models.CarouselImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarouselRepository extends JpaRepository<CarouselImage, String> {
}
