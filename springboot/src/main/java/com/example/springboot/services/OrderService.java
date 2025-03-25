package com.example.springboot.services;

import com.example.springboot.models.Order;
import com.example.springboot.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Lấy danh sách đơn hàng
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Lấy đơn hàng theo ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // Thêm đơn hàng mới
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    // Xóa đơn hàng theo ID
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
