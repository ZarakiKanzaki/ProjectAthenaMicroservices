package com.projectAthena.core.usecases;

public class DomainException extends Exception {

    public DomainException() {
    }

    public DomainException(String message) {
        super(message);
    }
}
