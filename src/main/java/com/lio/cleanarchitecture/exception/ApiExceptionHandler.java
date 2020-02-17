package com.lio.cleanarchitecture.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException exception, WebRequest request) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        String message = exception.getMessage();

        return handleExceptionInternal(exception, message, new HttpHeaders(), badRequest, request);
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException exception, WebRequest request) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        String message = exception.getMessage();

        return handleExceptionInternal(exception, message, new HttpHeaders(), notFound, request);
    }
}
