package com.company.oop.cosmetics.models.exceptions;

public class DuplicateNameException extends  RuntimeException {
    public DuplicateNameException(String message) {
        super(message);
    }
}
