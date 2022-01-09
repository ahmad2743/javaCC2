package com.trademe.application.softwarearchitectecc2.kernel;

import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;

public class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(MemberId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }
}
