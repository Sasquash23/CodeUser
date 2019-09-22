package com.kodilla.good.patterns.food2Door;

import java.util.List;

public class FoodOrderService {
    public void processAllOrders(List<FoodOrderRequest> orderRequest) {

        orderRequest.stream()
                .map(n -> {
                    System.out.println("We're processing your order " + n.getCustomer().getName());
                    return n.getFoodProducer().process(n.getCustomer(), n.getProductOrderRequest());
                })
                .forEach(t -> System.out.println("Order finished with success: " + t + "\n"));
    }
}
