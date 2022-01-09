package com.trademe.application.softwarearchitectecc2.exposition;

import com.sun.istack.NotNull;

import java.util.Optional;

public class AddressRequest {
    @NotNull
    public int streetNumber;
    @NotNull
    public String streetName;
    @NotNull
    public String city;
    @NotNull
    public String zipCode;
    public String additionalAddress;


}
