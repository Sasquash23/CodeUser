package com.kodilla.good.patterns.food2Door;

import java.util.Map;

public class FoodOrderRequest {
    private Customer customer;
    private FoodProducer foodProducer;
    private Map<Product, Integer> productOrderRequest;


    public FoodOrderRequest(Customer customer, FoodProducer foodProducer, Map<Product, Integer> productOrderRequest) {
        this.customer = customer;
        this.foodProducer = foodProducer;
        this.productOrderRequest = productOrderRequest;
    }

    public Customer getCustomer() {
        return customer;
    }

    public FoodProducer getFoodProducer() {
        return foodProducer;
    }

    public Map<Product, Integer> getProductOrderRequest() {
        return productOrderRequest;
    }
}
