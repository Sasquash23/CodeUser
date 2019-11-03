package com.kodilla.good.patterns.flight;

import java.util.List;

public class FlightService {
    public static void main(String[] args) {
        FlightsData flightsData = new FlightsData();
        FlightsProcessor flightProcessor = new FlightsProcessor(flightsData.getAirports(), flightsData.getDirectFlights());
        List<DirectFlight> directFlights = flightProcessor.getDirectFlights();

        System.out.println("DIRECT SEARCHER:");
        System.out.println("Finding all available direct flights...");
        for (DirectFlight directFlight : directFlights) {
            System.out.println(directFlight);
        }

        System.out.println();

        List<DirectFlight> flightsFrom = flightProcessor.getFlightsFrom(new Airport("ZRH","Zurych"));
                System.out.println("Finding all flights from ZRH...");
        for (DirectFlight directFlight : flightsFrom) {
            System.out.println(directFlight);
        }

        System.out.println();
        System.out.println("CONNECTION SEARCHER:");
        System.out.println("Serching for all flights with change in KTW...");
        for (ConnectingFlight flightWithAChange: flightProcessor.getFlightsThrough(new Airport("KTW", "Katowice"))) {
            System.out.println(flightWithAChange);
        }

        System.out.println();
        System.out.println("FLY SEARCHER:");
        System.out.println("Serching for fly WAW - MUC...");
        for (Flight flight: flightProcessor.findFlight(new Airport("WAW", "Warszawa"), new Airport("AMS", "Amsterdam"))) {
            System.out.println(flight);
        }

        System.out.println();

    }
}
