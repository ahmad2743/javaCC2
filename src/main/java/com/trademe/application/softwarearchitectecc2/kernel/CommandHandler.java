package com.trademe.application.softwarearchitectecc2.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}