package com.onlineshop.alraeaei.services;

import com.onlineshop.alraeaei.dtos.OrderDTO;
import com.onlineshop.alraeaei.models.Order;
import com.onlineshop.alraeaei.models.OrderProduct;
import com.onlineshop.alraeaei.repositories.OrderProductRepository;
import com.onlineshop.alraeaei.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    ProductService productService;
    OrderRepository orderRepository;
    OrderProductRepository orderProductRepository;


    public void createOrder(OrderDTO orderDTO) {
        List<OrderProduct> orderProductList = orderDTO.getProducts().stream()
                .map(orderProductDTO -> orderProductRepository.save(new OrderProduct(productService.getProduct(orderProductDTO.getProductId()), orderProductDTO.getQuantity())))
                .collect(Collectors.toList());
        orderRepository.save(new Order(
                orderProductList,
                orderDTO.getFirstName(),
                orderDTO.getLastName(),
                orderDTO.getEmail(),
                orderDTO.getAddress(),
                orderDTO.getZipCode(),
                orderDTO.getState()
        ));
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Product is not found!"));
        orderRepository.deleteById(orderId);
        order.getOrderProducts()
                .forEach(orderProduct -> orderProductRepository.deleteById(orderProduct.getId()));

    }
}
