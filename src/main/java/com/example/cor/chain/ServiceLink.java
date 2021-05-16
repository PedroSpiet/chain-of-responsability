package com.example.cor.chain;

import java.util.Optional;

public abstract class ServiceLink {
    private ServiceLink nextLink;

    public ServiceLink andThen(ServiceLink nextLink) {
        this.nextLink = nextLink;
        return nextLink;
    }

    public void doNext(String message) {
        handle(message);
        Optional.ofNullable(nextLink).ifPresent(next -> {
            next.doNext(message);
        });
    }

    public abstract void handle(String message);
}
