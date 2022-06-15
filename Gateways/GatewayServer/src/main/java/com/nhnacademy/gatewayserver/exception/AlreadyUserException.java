package com.nhnacademy.gatewayserver.exception;

public class AlreadyUserException extends RuntimeException{
    public AlreadyUserException(String message) {
        super(message);
    }
}
