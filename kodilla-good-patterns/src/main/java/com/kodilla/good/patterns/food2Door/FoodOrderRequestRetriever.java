package com.kodilla.good.patterns.food2Door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FoodOrderRequestRetriever {

    public List<FoodOrderRequest> retrieve(Customer customer) {
        List<FoodOrderRequest> orderRequestList = new ArrayList<>();

        FoodProducer foodProducer = new GlutenFreeShop();
        Map<Product, Integer> productsList = new HashMap<>();

        FoodProducer foodProducer1 = new HealthyShop();
        productsList.put(new HealthyShopProduct( foodProducer1,"bananas", 12,  "Bananas are high in potassium and contain good levels of protein and dietary fiber", 500), 50);

        FoodProducer foodProducer2 = new ExtraFoodShop();
        productsList.put(new ExtraFoodShopProduct( foodProducer2,"bananas", 20,"Bananas are high in potassium and contain good levels of protein and dietary fiber", 100), 30);

        FoodProducer foodProducer3 = new GlutenFreeShop();
        productsList.put(new ExtraFoodShopProduct(foodProducer3,"bread", 20, "Gluten-free living does not necessarily mean you're doomed to live a life without bread", 300), 30);

        for (Map.Entry<Product, Integer> entry : productsList.entrySet()) {
            entry.getKey().getProducer().process(customer, productsList);
        }

        return orderRequestList;
    }
}
