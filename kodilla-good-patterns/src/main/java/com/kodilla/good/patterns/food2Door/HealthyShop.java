package com.kodilla.good.patterns.food2Door;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class HealthyShop implements FoodProducer {

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrders) {
        for (Map.Entry<Product, Integer> entry : productsOrders.entrySet()) {
            String currProducer = entry.getKey().getProducer().getClass().getSimpleName();
            if (currProducer.equals("HealthyShop")) {
                System.out.println("For customer " + customer.getName() + " current order from HealthyShop:");
                System.out.println(entry.getKey().getProductName() + " : " + entry.getValue());
                System.out.println("Two more " + entry.getKey().getProductName() + " gratis.");
            }
        }
        return true;
    }
}
