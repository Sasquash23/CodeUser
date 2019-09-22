package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;

public class ProductOrderRequest {

    private User user;
    private Product product;
    private int quantity;
    private LocalDateTime orderDate;
    private LocalDateTime plannedDeliverDate;

    public ProductOrderRequest(User user, Product product, int quantity, LocalDateTime orderDate, LocalDateTime plannedDeliverDate) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.plannedDeliverDate = plannedDeliverDate;
    }

    public User getUser() {
        return user;
    }


    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getPlannedDeliverDate() {
        return plannedDeliverDate;
    }
}
