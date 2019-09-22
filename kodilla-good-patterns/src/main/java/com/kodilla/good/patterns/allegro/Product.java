package com.kodilla.good.patterns.allegro;

import java.math.BigDecimal;

abstract class Product {

    private String productName;
    private BigDecimal productPrice;
    private String productSeller;
    private String productDescription;

    public Product(String productName, String productSeller, BigDecimal productPrice, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSeller = productSeller;
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return  "productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productSeller=" + productSeller + '\'' +
                ", productDescription='" + productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductSeller() {
        return productSeller;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
