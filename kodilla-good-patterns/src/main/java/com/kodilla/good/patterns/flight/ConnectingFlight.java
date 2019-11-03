package com.kodilla.good.patterns.flight;


public class ConnectingFlight extends Flight {
    private final Airport through;

    public ConnectingFlight(final Airport from, final Airport through, final Airport to) {
        super(from, to);
        this.through = through;
    }

    @Override
    public String toString() {

        return "Flights " +
                ": " + from.getAirportId() + " - " + through.getAirportId() + " - " + to.getAirportId() +
                " (" + from + " - " + through + " - " + to +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectingFlight that = (ConnectingFlight) o;

        if (!from.equals(that.from)) return false;
        if (!to.equals(that.to)) return false;
        return through.equals(that.through);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + through.hashCode();
        return result;
    }
}
