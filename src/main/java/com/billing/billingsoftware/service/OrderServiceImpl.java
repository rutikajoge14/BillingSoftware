package com.billing.billingsoftware.service;

import com.billing.billingsoftware.entity.Order;
import com.billing.billingsoftware.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order createOrder(Order order) {
        return repository.createOrder(order);
    }

    @Override
    public Order getOrderById(String orderId) {
        return repository.getOrderById(orderId);
    }

    @Override
    public List<Order> getAllOrder() {
        return repository.getAllOrder();
    }

    @Override
    public Order updateStatus(String orderId, String status) {
        return repository.updateStatus(orderId, status);
    }

    @Override
    public Order cancelOrder(String orderId) {
        return repository.cancelOrder(orderId);
    }
}
