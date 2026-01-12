package com.billing.billingsoftware.entity;

public class InvoiceItem {

    int id;
    Product product;
    String quantity;
    int price;
    double taxAmount;
    double total;

    public InvoiceItem(int id, Product product, String quantity, int price, double taxAmount, double total) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.taxAmount = taxAmount;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
