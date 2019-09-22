package com.kodilla.good.patterns.food2Door;

import java.util.Map;

public class ExtraFoodShop implements FoodProducer {

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrders) {
        String textCheck = "ExtraFoodShop";

        productsOrders.entrySet()
                .stream()
                .forEach(entry -> {
                    if (textCheck.equals(entry.getKey().getProducerName())) {
                        System.out.println("For customer " + customer.getName() + " current order from ExtraFoodShop:");
                        System.out.println(entry.getKey().getProductName() + " : " + entry.getValue());
                        System.out.println("Lower prise 2% for product " + entry.getKey().getProductName());
                    }
                });

        return true;
    }

}
