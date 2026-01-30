package com.billing.billingsoftware.repository;

import com.billing.billingsoftware.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final List<Order> list = new ArrayList<>();

    public Order createOrder(Order order) {
        list.add(order);
        return order;
    }

    public Order getOrderById(String orderId) {
        for (Order order : list) {
            if (orderId.equals(order.getOrderId())) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrder() {
        return list;
    }

    public Order updateStatus(String orderId, String status) {
        for (Order order : list) {
            if (orderId.equals(order.getOrderId())) {
                order.setStatus(status);
                return order;
            }
        }
        return null;
    }

    public Order cancelOrder(String orderId) {
        for (int i = 0; i < list.size(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                return list.remove(i);
            }
        }
        return null;
    }
}
