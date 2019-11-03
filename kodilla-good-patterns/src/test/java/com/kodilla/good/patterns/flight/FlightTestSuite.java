package com.kodilla.good.patterns.flight;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FlightTestSuite {
    private static List<Airport> sampleAirports = new ArrayList<>();
    private static List<DirectFlight> sampleDirectFlights = new ArrayList<>();
    private static FlightsProcessor flightsProcessor;
    private static FlightsData flightsData;
    private static Airport airport1, airport2, airport3, airport4, airport5;
    private static DirectFlight directFlight1, directFlight2, directFlight3, directFlight4;
    private static ConnectingFlight flight213, flight215, flight312, flight124, flight421, flight134, flight431, flight243;

    private static void generateSampleData() {

        airport1 = new Airport("1", "airport1");
        airport2 = new Airport("2", "airport2");
        airport3 = new Airport("3", "airport3");
        airport4 = new Airport("4", "airport4");
        airport5 = new Airport("5", "airport5");

        //airport1: flights from: 4, flights to: 4
        airport1.setDepartureAirports(Arrays.asList(airport2, airport3, airport4, airport5));
        //airport2: flights from: 2, flights to: 2
        airport2.setDepartureAirports(Arrays.asList(airport1, airport4));
        //airport3: flights from: 3, flights to: 2
        airport3.setDepartureAirports(Arrays.asList(airport1, airport4));
        //airport4: flights from: 1, flights to: 2
        airport4.setDepartureAirports(Arrays.asList(airport1, airport2, airport3));
        //airport5: flights from: 1, flights to: 1
        airport5.setDepartureAirports(Arrays.asList(airport1));

        //all airports list
        sampleAirports = Arrays.asList(airport1, airport2, airport3, airport4, airport5);

        for (Airport airport: sampleAirports) {
            //generate all available flights
            airport.getDepartureAirports()
                    .forEach(destination -> sampleDirectFlights.add(new DirectFlight(airport, destination)));
        }

        //given
        //through airport1
        flight213 = new ConnectingFlight(airport2, airport1, airport3);
        flight215 = new ConnectingFlight(airport2, airport1, airport5);
        flight312 = new ConnectingFlight(airport3, airport1, airport2);
        //through airport2
        flight124 = new ConnectingFlight(airport1, airport2, airport4);
        flight421 = new ConnectingFlight(airport4, airport2, airport1);
        //through airport3
        flight134 = new ConnectingFlight(airport1, airport3, airport4);
        flight431 = new ConnectingFlight(airport4, airport3, airport1);
        //through airport4
        flight243 = new ConnectingFlight(airport2, airport4, airport3);
    }

    @BeforeClass
    public static void beforeClass(){
        //given
        generateSampleData();
        flightsData = mock(FlightsData.class);
        when(flightsData.getAirports()).thenReturn(sampleAirports);
        when(flightsData.getDirectFlights()).thenReturn(sampleDirectFlights);
        flightsProcessor = new FlightsProcessor(flightsData.getAirports(), flightsData.getDirectFlights());
        directFlight1 = new DirectFlight(airport1, airport2);
        directFlight2 = new DirectFlight(airport1, airport3);
        directFlight3 = new DirectFlight(airport1, airport4);
        directFlight4 = new DirectFlight(airport1, airport5);
    }

    @Test
    public void testGetFlights() {
        //when
        List<DirectFlight> directFlights = flightsProcessor.getDirectFlights();
        //then
        Assert.assertEquals(12, directFlights.size());
    }

    @Test
    public void testGetFlightsFrom() {
        //when
        List<DirectFlight> flightsFromAirport1 = flightsProcessor.getFlightsFrom(sampleAirports.get(0));
        List<DirectFlight> flightsFromAirport2 = flightsProcessor.getFlightsFrom(sampleAirports.get(1));
        List<DirectFlight> flightsFromAirport3 = flightsProcessor.getFlightsFrom(sampleAirports.get(2));
        List<DirectFlight> flightsFromAirport4 = flightsProcessor.getFlightsFrom(sampleAirports.get(3));
        List<DirectFlight> flightsFromAirport5 = flightsProcessor.getFlightsFrom(sampleAirports.get(4));

        //then
        Assert.assertEquals(4, flightsFromAirport1.size());
        Assert.assertEquals(2, flightsFromAirport2.size());
        Assert.assertEquals(2, flightsFromAirport3.size());
        Assert.assertEquals(3, flightsFromAirport4.size());
        Assert.assertEquals(1, flightsFromAirport5.size());

        Assert.assertTrue(flightsFromAirport1.containsAll(Arrays.asList(directFlight1, directFlight2, directFlight3, directFlight4)));
    }

    @Test
    public void testGetFlightsTo() {
        //when
        List<DirectFlight> flightsToAirport1 = flightsProcessor.getFlightsTo(sampleAirports.get(0));
        List<DirectFlight> flightsToAirport2 = flightsProcessor.getFlightsTo(sampleAirports.get(1));
        List<DirectFlight> flightsToAirport3 = flightsProcessor.getFlightsTo(sampleAirports.get(2));
        List<DirectFlight> flightsToAirport4 = flightsProcessor.getFlightsTo(sampleAirports.get(3));
        List<DirectFlight> flightsToAirport5 = flightsProcessor.getFlightsTo(sampleAirports.get(4));

        //then
        Assert.assertEquals(4, flightsToAirport1.size());
        Assert.assertEquals(2, flightsToAirport2.size());
        Assert.assertEquals(2, flightsToAirport3.size());
        Assert.assertEquals(3, flightsToAirport4.size());
        Assert.assertEquals(1, flightsToAirport5.size());

        Assert.assertTrue(flightsToAirport5.contains(directFlight4));
    }

    @Test
    public void testGetFlightsThrough() {
        //when
        List<ConnectingFlight> flightsThroughAirport1 = flightsProcessor.getFlightsThrough(sampleAirports.get(0));
        List<ConnectingFlight> flightsThroughAirport2 = flightsProcessor.getFlightsThrough(sampleAirports.get(1));
        List<ConnectingFlight> flightsThroughAirport3 = flightsProcessor.getFlightsThrough(sampleAirports.get(2));
        List<ConnectingFlight> flightsThroughAirport4 = flightsProcessor.getFlightsThrough(sampleAirports.get(3));
        List<ConnectingFlight> flightsThroughAirport5 = flightsProcessor.getFlightsThrough(sampleAirports.get(4));

        //then
        Assert.assertEquals(12, flightsThroughAirport1.size());
        Assert.assertEquals(2, flightsThroughAirport2.size());
        Assert.assertEquals(2, flightsThroughAirport3.size());
        Assert.assertEquals(6, flightsThroughAirport4.size());
        Assert.assertEquals(0, flightsThroughAirport5.size());

        Assert.assertTrue(flightsThroughAirport1.containsAll(Arrays.asList(flight213, flight215, flight312)));
        Assert.assertTrue(flightsThroughAirport2.containsAll(Arrays.asList(flight124, flight421)));
        Assert.assertTrue(flightsThroughAirport3.containsAll(Arrays.asList(flight134, flight431)));
        Assert.assertTrue(flightsThroughAirport4.contains(flight243));
    }

    @Test
    public void testFindFlight() {
        //given
        ConnectingFlight flight214 = new ConnectingFlight(airport2, airport1, airport4);
        ConnectingFlight flight234 = new ConnectingFlight(airport2, airport3, airport4);
        ConnectingFlight flight215 = new ConnectingFlight(airport2, airport1, airport5);
        ConnectingFlight flight315 = new ConnectingFlight(airport3, airport1, airport5);

        //when
        List<Flight> findedDirectFlight1 = flightsProcessor.findFlight(airport1, airport2);
        List<Flight> findedDirectFlight2 = flightsProcessor.findFlight(airport1, airport3);
        List<Flight> findedDirectFlight3 = flightsProcessor.findFlight(airport1, airport4);
        List<Flight> findedDirectFlight4 = flightsProcessor.findFlight(airport1, airport5);

        List<Flight> findedFlight24 = flightsProcessor.findFlight(airport2, airport4);
        List<Flight> findedFlight25 = flightsProcessor.findFlight(airport2, airport5);
        List<Flight> findedFlight35 = flightsProcessor.findFlight(airport3, airport5);

        //then
        Assert.assertEquals(Arrays.asList(directFlight1), findedDirectFlight1);
        Assert.assertEquals(Arrays.asList(directFlight2), findedDirectFlight2);
        Assert.assertEquals(Arrays.asList(directFlight3), findedDirectFlight3);
        Assert.assertEquals(Arrays.asList(directFlight4), findedDirectFlight4);

        Assert.assertEquals(Arrays.asList(flight215), findedFlight25);
        Assert.assertEquals(Arrays.asList(flight315), findedFlight35);

    }
}
