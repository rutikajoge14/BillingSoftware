package com.billing.billingsoftware.dto;

import java.util.List;

public class InvoiceRequestDTO {

    private int customerId;
    private double discount;
    private List<ItemRequestDTO> items;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<ItemRequestDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemRequestDTO> items) {
        this.items = items;
    }

    public static class ItemRequestDTO{
        private int productId;
        private int quantity;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
