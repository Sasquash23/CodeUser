package com.kodilla.exception.test;

public class ThirdChallenge {
    public static void main(String[] args){
        Flight flightCraWar = new Flight("CRACOW","WARSAW");
        Flight flightCraAms = new Flight("CRACOW", "AMSTERDAM");
        Flight flightBerPar = new Flight( "BERLIN", "PARIS");

        FlightSearch flightSearch = new FlightSearch();

        try {
            boolean checkCraWar = flightSearch.findFilght(flightCraWar);
            System.out.println("Flight Cracow - Warsaw exist - status for booking: " + checkCraWar);
        } catch (RouteNotFoundException e) {
            System.out.println("Write correct airport name.");
        }
        try {
            boolean checkCraAms = flightSearch.findFilght(flightCraAms);
            System.out.println("Flight Cracow - Amstredam exist - status for booking: " + checkCraAms);
        } catch (RouteNotFoundException e) {
            System.out.println("Write correct airport name.");
        }
        try {
            boolean checkBerPar = flightSearch.findFilght(flightBerPar);
            System.out.println("Flight Barlin - Paris exist -status for booking: " + checkBerPar);
        } catch (RouteNotFoundException e) {
            System.out.println("Write correct airport name.");
        }
    }
}
