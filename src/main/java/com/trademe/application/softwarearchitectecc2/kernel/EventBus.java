package com.trademe.application.softwarearchitectecc2.kernel;

import java.util.List;

public interface EventBus <E extends Event>{
    void publish(E event);

    void register(Class<? extends E> classE, List<EventListener<? extends E>> eventListeners);
}
