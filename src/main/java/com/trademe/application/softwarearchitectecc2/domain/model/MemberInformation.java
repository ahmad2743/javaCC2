package com.trademe.application.softwarearchitectecc2.domain.model;

import java.util.Objects;
public class MemberInformation {
    private final String email;
    private String password;
    private String callNumber;
    private Address address;

    public MemberInformation(String email, String password, String callNumber, Address address) {
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.callNumber = Objects.requireNonNull(callNumber);
        this.address = Objects.requireNonNull(address);
    }

    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password);
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = Objects.requireNonNull(callNumber);
    }

    public void setAddress(Address address) {
        this.address = Objects.requireNonNull(address);
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberInformation that = (MemberInformation) o;
        return Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(callNumber, that.callNumber) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, callNumber, address);
    }

    @Override
    public String toString() {
        return "MemberInformation{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", callNumber='" + callNumber + '\'' +
                ", address=" + address +
                '}';
    }
}