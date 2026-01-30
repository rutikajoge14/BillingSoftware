package com.billing.billingsoftware.service;

import com.billing.billingsoftware.entity.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);
    Order getOrderById(String orderId);
    List<Order> getAllOrder();
    Order updateStatus(String orderId, String status);
    Order cancelOrder(String orderId);

}
