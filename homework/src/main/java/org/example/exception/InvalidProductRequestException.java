package org.example.exception;

import java.util.List;

public class InvalidProductRequestException extends RuntimeException{

    private final List<String> errors;

    public InvalidProductRequestException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
