package com.example.teacherstudentmanagement.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String ex) {
        super(ex);
    }
}
