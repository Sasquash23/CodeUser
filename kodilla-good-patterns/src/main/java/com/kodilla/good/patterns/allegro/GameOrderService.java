package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;
import java.util.Random;

public class GameOrderService implements ProductOrderService {
    @Override
    public boolean order(User user, Product product, int quantity, LocalDateTime orderDate, LocalDateTime deliverDate) {
        return new Random().nextBoolean();
    }
}
