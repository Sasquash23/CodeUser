package com.kodilla.good.patterns.flight;

public class Flight {
    protected final Airport from;
    protected final Airport to;

    public Flight(final Airport from, final Airport to) {
        this.from = from;
        this.to = to;
    }


}
