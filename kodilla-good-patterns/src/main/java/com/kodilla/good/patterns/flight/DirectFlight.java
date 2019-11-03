package com.kodilla.good.patterns.flight;

public class DirectFlight extends Flight {
    private int number;
    private String flightId;

    public DirectFlight(final Airport from, final Airport to) {
        super(from, to);
    }

    @Override
    public String toString() {
        return "Flight " + number +
                ": " + flightId +
                " (" + from +
                " - " + to +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectFlight that = (DirectFlight) o;

        if (!from.equals(that.from)) return false;
        return to.equals(that.to);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getNumber() {
        return number;
    }

    public String getFlightId() {
        return flightId;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }
}