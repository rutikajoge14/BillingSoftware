package com.billing.billingsoftware.entity;

import java.util.UUID;

public class Order {

    private String orderId;
    private int productId;
    private int qty;
    private double amount;
    private String status;

    public Order() {
    }

    public Order(int productId, int qty, double amount, String status) {
        this.productId = productId;
        this.qty = qty;
        this.amount = amount;
        this.status = status;
        this.orderId = UUID.randomUUID().toString();
    }

    public String getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
