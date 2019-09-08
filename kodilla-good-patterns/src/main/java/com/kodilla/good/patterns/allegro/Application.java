package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {

        User user = new User("Sasquash23", "Joana", "Ceddia");

        LocalDateTime orderDate = LocalDateTime.of(2017, 5, 20, 21, 25);

        ProductOrderRequestRetriever productOrderRequestRetriever = new ProductOrderRequestRetriever();
        ProductOrderRequest productOrderRequest = productOrderRequestRetriever.retrieve(user, orderDate);
        System.out.println("Please wait moment, order is being processed...\n");

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(new MailService(), new GameOrderService(), new GameOrderRepository());
        productOrderProcessor.process(productOrderRequest);
    }
}
