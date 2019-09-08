package com.kodilla.good.patterns.food2Door;

import java.math.BigDecimal;

abstract class Product {
    private String productName;
    private int productPrice;
    private FoodProducer producer;
    private String additionalInfo;
    private int productQunatityMagazin;

    public Product(String productName, int productPrice, FoodProducer producer, String additionalInfo, int productQunatityMagazin) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.producer = producer;
        this.additionalInfo = additionalInfo;
        this.productQunatityMagazin = productQunatityMagazin;
    }

    @Override
    public String toString() {
        return "productName='" + productName + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return productName.hashCode();
    }

    public String getProductName() {
        return productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public FoodProducer getProducer() {
        return producer;
    }

    public int getProductQunatityMagazin() {
        return productQunatityMagazin;
    }
}

