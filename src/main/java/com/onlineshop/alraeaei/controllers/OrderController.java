package com.onlineshop.alraeaei.controllers;

import com.onlineshop.alraeaei.dtos.OrderDTO;
import com.onlineshop.alraeaei.models.Order;
import com.onlineshop.alraeaei.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
@AllArgsConstructor
public class OrderController {
    OrderService orderService;
    @PostMapping
    public void createOrder(@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
    }
    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") String orderId){
        orderService.deleteOrder(orderId);
    }
}
