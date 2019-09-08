package com.kodilla.good.patterns.allegro;


import java.time.LocalDateTime;
import java.util.Random;

public class GameOrderRepository implements ProductOrderRepository {

    @Override
    public boolean createProductOrder(User user, Product product, int quantity, LocalDateTime orderDat, LocalDateTime plannedDeliverDate) {
        return new Random().nextBoolean();
    }
}
