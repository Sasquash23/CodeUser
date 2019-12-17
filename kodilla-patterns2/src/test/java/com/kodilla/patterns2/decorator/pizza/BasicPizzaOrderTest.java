package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BasicPizzaOrderTest {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = pizza.getCost();
        String description = pizza.getDescription();
        //Then
        assertEquals(new BigDecimal(20), calculatedCost);
        assertEquals("Pizza basic", description);

    }

    @Test
    public void testBasicPizzaOrderGetCostWithAllIng() {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new CheeseDecorator(pizza);
        pizza = new PeperoniDecorator(pizza);
        pizza = new OlivesDecorator(pizza);

        //When
        BigDecimal calculatedCost = pizza.getCost();
        String description = pizza.getDescription();
        //Then
        assertEquals(new BigDecimal(35), calculatedCost);
        assertEquals("Pizza basic + Cheese + Peperoni + Olives", description);

    }

    @Test
    public void testBasicPizzaOrderGetCostWithCheese() {
        //Given
        PizzaOrder pizza = new BasicPizzaOrder();
        pizza = new CheeseDecorator(pizza);
        //When
        BigDecimal calculatedCost = pizza.getCost();
        String description = pizza.getDescription();
        //Then
        assertEquals(new BigDecimal(25), calculatedCost);
        assertEquals("Pizza basic + Cheese", description);

    }

}