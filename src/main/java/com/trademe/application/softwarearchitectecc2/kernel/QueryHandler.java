package com.trademe.application.softwarearchitectecc2.kernel;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}

