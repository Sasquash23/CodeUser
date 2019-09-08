package com.kodilla.good.patterns.food2Door;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Julia", "Pope");

        FoodOrderRequestRetriever productOrderRequestRetriever = new FoodOrderRequestRetriever();
        productOrderRequestRetriever.retrieve(customer1);
    }
}
