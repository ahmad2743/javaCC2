package com.trademe.application.softwarearchitectecc2.kernel;

public interface EventListener<E extends Event> {
    void listenTo(E event);
}
