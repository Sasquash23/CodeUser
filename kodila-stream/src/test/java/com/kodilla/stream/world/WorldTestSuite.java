package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent africa = new Continent("Africa");
        Continent antarctica = new Continent("Antarctica");
        Continent asia = new Continent("Asia");
        Continent europe = new Continent("Europe");
        Continent northAmerica = new Continent("North America");
        Continent southAmerica = new Continent("South America");
        Continent oceania = new Continent("Oceania");

        Country algeria = new Country("Algeria");
        Country egypt = new Country("Egypt");
        Country nigeria = new Country("Nigeria");
        Country afghanistan = new Country("Afghanistan");
        Country china = new Country("China");
        Country laos = new Country("Laos");
        Country norway = new Country("Norway");
        Country poland = new Country("Poland");
        Country unitedKingdom = new Country("United Kingdom");
        Country belize = new Country("Belize");
        Country canada = new Country("Canada");
        Country unitedStatesOfAmerica = new Country("United States of America");
        Country argentina = new Country("Argentina");
        Country brazil = new Country("Brazil");
        Country chile = new Country("Chile");
        Country australia = new Country("Australia");
        Country fiji = new Country("Fiji");
        Country tonga = new Country("Tonga");

        world.addContinent(africa);
        world.addContinent(antarctica);
        world.addContinent(asia);
        world.addContinent(europe);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);
        world.addContinent(oceania);

        africa.addCountry(algeria);
        africa.addCountry(egypt);
        africa.addCountry(nigeria);
        asia.addCountry(afghanistan);
        asia.addCountry(china);
        asia.addCountry(laos);
        europe.addCountry(norway);
        europe.addCountry(poland);
        europe.addCountry(unitedKingdom);
        northAmerica.addCountry(belize);
        northAmerica.addCountry(canada);
        northAmerica.addCountry(unitedStatesOfAmerica);
        southAmerica.addCountry(argentina);
        southAmerica.addCountry(brazil);
        southAmerica.addCountry(chile);
        oceania.addCountry(australia);
        oceania.addCountry(fiji);
        oceania.addCountry(tonga);

        //When
        BigDecimal totalNumberOfPeople = world.getPeopleQuantity();

        //Then
        BigDecimal expectedNumberOfPeople = new BigDecimal("2222222202");
        Assert.assertEquals(expectedNumberOfPeople, totalNumberOfPeople);
    }
}
