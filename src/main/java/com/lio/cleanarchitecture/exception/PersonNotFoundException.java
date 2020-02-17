package com.lio.cleanarchitecture.exception;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PersonNotFoundException(UUID id) {
        super(String.format("Person is not found with id: " + id));
    }
}
