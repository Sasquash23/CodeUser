package com.kodilla.testing.shape;

import java.util.Objects;

import static java.lang.Double.valueOf;

public class Square implements Shape{
    private  String name =  this.getClass().getSimpleName();
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.sideLength, sideLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valueOf(sideLength));
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(sideLength, 2);
    }
}
