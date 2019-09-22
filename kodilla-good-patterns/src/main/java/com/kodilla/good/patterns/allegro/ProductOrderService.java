package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;

interface ProductOrderService {
    boolean order(User user, Product product, int quantity,  LocalDateTime orderDate, LocalDateTime plannedDeliverDate);
}
