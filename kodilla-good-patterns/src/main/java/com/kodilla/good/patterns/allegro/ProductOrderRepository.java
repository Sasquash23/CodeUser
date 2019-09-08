package com.kodilla.good.patterns.allegro;

import java.time.LocalDateTime;

public interface ProductOrderRepository {
    boolean createProductOrder(User user, Product product, int quantity, LocalDateTime orderDate, LocalDateTime plannedDeliverDate);
}
