package com.kodilla.testing.shape;

import java.util.Objects;

import static java.lang.Double.*;

public class Trinagle implements Shape {
    private String name =  this.getClass().getSimpleName();
    private double sideLengthA;
    private double sideLengthB;
    private double sideLengthC;

    public Trinagle(double sideLengthA, double sideLengthB, double sideLengthC) {
        this.sideLengthA = sideLengthA;
        this.sideLengthB = sideLengthB;
        this.sideLengthC = sideLengthC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trinagle trinagle = (Trinagle) o;
        return compare(trinagle.sideLengthA, sideLengthA) == 0 &&
                compare(trinagle.sideLengthB, sideLengthB) == 0 &&
                compare(trinagle.sideLengthC, sideLengthC) == 0;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(sideLengthA, sideLengthB, sideLengthC);
        Integer s_int = new Integer("223");
        int result = Objects.hashCode(valueOf(sideLengthA));
        result = (31 * result) + Objects.hashCode(valueOf(sideLengthB));
        result = (31 * result)  +Objects.hashCode(valueOf(sideLengthC));
        return result;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        if (checkTringleSides()){
            //double semiPerimeter = getsemiPerimeter();
            return heronsFormula(semiPerimeter());
        } else {
            return 0;
        }
    }

    public boolean checkTringleSides() {
        return(sideLengthA + sideLengthB > sideLengthC &&
                sideLengthA + sideLengthC > sideLengthB &&
                sideLengthB + sideLengthC > sideLengthA);
    }

    public double semiPerimeter(){
        return (sideLengthA + sideLengthB + sideLengthC)/2;
    }

    public double heronsFormula (double s) {
        return Math.sqrt(s*(s-sideLengthA)*(s-sideLengthB)*(s-sideLengthC));
    }
}
