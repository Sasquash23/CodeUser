package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public final class Country implements PeopleQuantity {

    private final BigDecimal peopleQuantity;
    private final String nameOfTheCountry;

    public Country(final BigDecimal peopleQuantity, final String nameOfTheCountry) {
        this.peopleQuantity = peopleQuantity;
        this.nameOfTheCountry = nameOfTheCountry;
    }

    public Country(final String nameOfTheCountry) {
        this(new BigDecimal("123456789"), nameOfTheCountry);
    }

    public String getNameOfTheCountry() {
        return nameOfTheCountry;
    }

    @Override
    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    @Override
    public String toString() {
        return "Country{" +
                "peopleQuantity=" + peopleQuantity +
                ", nameOfTheCountry='" + nameOfTheCountry + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(nameOfTheCountry, country.nameOfTheCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheCountry);
    }
}
