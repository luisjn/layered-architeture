package com.lio.cleanarchitecture.exception;

public class ApiRequestException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ApiRequestException(String message) {
        super(message);
    }
}
