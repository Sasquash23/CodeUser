package com.kodilla.stream.world;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class Continent {

    private final String nameOfTheContinent;
    private final List<Country> listOfCountries = new ArrayList<>();

    public Continent(String nameOfTheContinent) {
        this.nameOfTheContinent = nameOfTheContinent;
    }

    public String getNameOfTheContinent() {
        return nameOfTheContinent;
    }

    public List<Country> getListOfCountries() {
        return listOfCountries;
    }

    public Set<String> getListOfCountriesPerContinent2() {
        return listOfCountries.stream()
                .map(continent -> continent.getNameOfTheCountry())
                .collect(Collectors.toSet());
    }

    public List<Country> getListOfCountriesPerContinent() {
        return new ArrayList<>(listOfCountries);
    }

    public boolean addCountry (Country country) {
        return listOfCountries.add(country);
    }

    @Override
    public String toString() {
        return "Continent{" +
                "nameOfTheContinent='" + nameOfTheContinent + '\'' +
                ", listOfCountries=" + listOfCountries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(nameOfTheContinent, continent.nameOfTheContinent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheContinent);
    }
}
