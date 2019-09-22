package com.kodilla.good.patterns.food2Door;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GlutenFreeShop implements FoodProducer {

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrders) {
        String textCheck = "GlutenFreeShop";

        productsOrders.entrySet()
                .stream()
                .forEach(entry -> {
                    if (textCheck.equals(entry.getKey().getProducerName())) {
                        System.out.println("For customer " + customer.getName() + " current order from GlutenFreeShop:");
                        System.out.println(entry.getKey().getProductName() + " : " + entry.getValue());
                        System.out.println("Gratis aceess for month to recipes to cook gluten free meal on site KodillaCokking.");
                    }
                });

        return true;
    }
}
