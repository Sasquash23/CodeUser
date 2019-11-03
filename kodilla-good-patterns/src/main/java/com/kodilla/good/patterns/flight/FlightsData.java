package com.kodilla.good.patterns.flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightsData {
    private final List<Airport> airports;
    private final List<DirectFlight> directFlights;

    public FlightsData() {
        airports = generateAllAirports();
        directFlights = generateDirectFlights(airports);
        setDirectFlightsNumbers(directFlights);
        setArrivalAirports(airports, directFlights);
        setFlightList(airports, directFlights);
        //setFlightFromLists(airports, directFlights);
    }

    private List<Airport> generateAllAirports(){
        Airport vie = new Airport("VIE", "Wiedyń");
        Airport ams = new Airport("AMS", "Amsterdam");
        Airport krk = new Airport("KRK", "Kraków");
        Airport ktw = new Airport("KTW", "Katowice");
        Airport zrh = new Airport("ZRH", "Zurych");
        Airport muc = new Airport("MUC", "Monachium");
        Airport nrt = new Airport("NRT", "Nartia");
        Airport waw = new Airport("WAW", "Warszawa");

        waw.setDepartureAirports(Arrays.asList(ktw, krk, zrh, nrt, vie, ams, muc));
        vie.setDepartureAirports(Arrays.asList(waw, krk, muc));
        ktw.setDepartureAirports(Arrays.asList(waw, muc));
        krk.setDepartureAirports(Arrays.asList(waw, vie));
        zrh.setDepartureAirports(Arrays.asList(waw));
        muc.setDepartureAirports(Arrays.asList(waw, ktw, vie));
        nrt.setDepartureAirports(Arrays.asList(waw));
        ams.setDepartureAirports(Arrays.asList(waw));

        return new ArrayList<>(Arrays.asList(waw, ams, ktw, krk, zrh, muc, nrt, ams));
    }

    private List<DirectFlight> generateDirectFlights(List<Airport> airports){
        List<DirectFlight> result = new ArrayList<>();
        for (Airport airport: airports) {
            airport.getDepartureAirports()
                    .forEach(destination -> result.add(new DirectFlight(airport, destination)));
        }
        return new ArrayList<>(result);
    }

    private void setDirectFlightsNumbers(List<DirectFlight> directFlights){
        int counter = 1;
        for (DirectFlight directFlight : directFlights) {
            directFlight.setNumber(counter++);
            //System.out.println(directFlight.getNumber() + " " + counter);
            directFlight.setFlightId(directFlight.getFrom().getAirportId()
                    + " - " + directFlight.getTo().getAirportId());
            //System.out.println(directFlight.getFlightId() + "Idd");
        }
    }

    private void setArrivalAirports(List<Airport> airports, List<DirectFlight> directFlights) {
        for (Airport airport : airports) {
            airport.setArrivalAirports(directFlights.stream()
                    .filter(flights -> flights.getTo().equals(airport))
                    .map(flight -> flight.getFrom())
                    .collect(Collectors.toList()));
        }
    }

    private void setFlightList(List<Airport> airports, List<DirectFlight> directFlights){
        for (Airport airport: airports) {
            airport.setDirectFlightToList(directFlights.stream()
                    .filter(flight -> flight.getFrom().equals(airport))
                    .collect(Collectors.toList()));
        }
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public List<DirectFlight> getDirectFlights() {
        return directFlights;
    }
}
