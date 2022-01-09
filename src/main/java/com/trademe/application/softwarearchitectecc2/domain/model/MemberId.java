package com.trademe.application.softwarearchitectecc2.domain.model;

import java.util.Objects;
import java.util.UUID;
public class MemberId {
    private final int value;

    public MemberId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberId memberId = (MemberId) o;
        return value == memberId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MemberId{" +
                "value=" + value +
                '}';
    }
}