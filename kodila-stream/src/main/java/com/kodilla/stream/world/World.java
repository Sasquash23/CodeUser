package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World implements PeopleQuantity{
    private final List<Continent> listOfAllContinents = new ArrayList<>();

    public boolean addContinent(Continent continent){
        return listOfAllContinents.add(continent);
    }

    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity =listOfAllContinents.stream()
                .flatMap(continent -> continent.getListOfCountriesPerContinent().stream())
                .distinct()
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, country) -> sum = sum.add(country));
        return peopleQuantity;
    }
}
