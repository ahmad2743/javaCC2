package com.trademe.application.softwarearchitectecc2.domain.model;

import lombok.Data;

import java.util.Objects;
import java.util.Optional;

@Data
public class Address {
    private int streetNumber;
    private String streetName;
    private String city;
    private String zipCode;
    private Optional<String> additionalAddress;

    public Address(int streetNumber, String streetName, String city, String zipCode, String additionalAddress) {
        this.streetNumber = Objects.requireNonNull(streetNumber);
        this.streetName = Objects.requireNonNull(streetName);
        this.city = Objects.requireNonNull(city);
        this.zipCode = Objects.requireNonNull(zipCode);
        this.additionalAddress = Optional.ofNullable(additionalAddress);
    }
    public static Address of(int streetNumber, String streetName, String city, String zipCode, String additionalAddress){
        return new Address(streetNumber, streetName, city, zipCode, additionalAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return streetNumber == address.streetNumber && Objects.equals(streetName, address.streetName) && Objects.equals(city, address.city) && Objects.equals(zipCode, address.zipCode) && Objects.equals(additionalAddress, address.additionalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, streetName, city, zipCode, additionalAddress);
    }
}
