package com.billing.billingsoftware.entity;

import java.util.Date;

public class Invoice {

    int invoiceId;
    Date invoiceDate;
    Customer customer;
    double totalAmount;
    double totalTax;
    double discount;
   double finalAmount;

    public Invoice(int invoiceId, Date invoiceDate, Customer customer, double totalAmount, double totalTax, double discount, double finalAmount) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.totalTax = totalTax;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }
}
