package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    private Map<String, Boolean> airportMap;

    public FlightSearch() {
        airportMap = airportDB();
    }

    public boolean findFilght(Flight flight) throws RouteNotFoundException {
        if (airportMap.containsKey(flight.getDepartureAirport()) && airportMap.containsKey(flight.getArrivalAirport())){
            return airportMap.get(flight.getDepartureAirport()) && airportMap.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException("Choosed airport not exist!");
        }
    }

    private Map<String, Boolean> airportDB() {
        Map<String, Boolean> airportDB = new HashMap<>();
        airportDB.put("BERLIN", true);
        airportDB.put("CRACOW", true);
        airportDB.put("AMSTERDAM", true);
        airportDB.put("WARSAW", false);
        airportDB.put("PARIS", true);

        return airportDB;

    }
}
