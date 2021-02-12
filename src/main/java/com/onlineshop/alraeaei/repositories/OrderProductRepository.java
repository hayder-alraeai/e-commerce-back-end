package com.onlineshop.alraeaei.repositories;

import com.onlineshop.alraeaei.dtos.OrderProductDTO;
import com.onlineshop.alraeaei.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, String> {
}
