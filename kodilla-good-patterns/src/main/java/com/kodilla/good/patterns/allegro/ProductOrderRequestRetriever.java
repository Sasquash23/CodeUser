package com.kodilla.good.patterns.allegro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductOrderRequestRetriever {

    public ProductOrderRequest retrieve(User user, LocalDateTime orderDate) {
        LocalDateTime plannedDeliverDate = orderDate.plusDays(5);
        Product product = new Game("Fifa 2019",
                "GoodPrice",
                new BigDecimal("70"),
                "The newest version of one of the best sport video game on the market!\n" +
                        "    New features, new gameplay and Champions League. Buy soccer video game FIFA 19 now!\n" +
                        "    FIFA 19 by EA Sports is here – the newest version of a football game that has legions of fans worldwide is now available!");
        int quantity = 1;


        System.out.println("Welcome on kodillegro: ");
        System.out.println("  Information about buyer: ");
        System.out.println("    Login: " + user.getUserLogin() +
                "\n    Name and Surname: " + user.getUserName() + " " + user.getUserSurname());
        System.out.println("  Ordered: " + product.getProductName() +
                "Description: " + product.getProductDescription());
        return new ProductOrderRequest(user, product, quantity, orderDate, plannedDeliverDate);
    }
}
