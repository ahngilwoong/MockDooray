package com.nhnacademy.accountapi.exception;

public class AlreadyUserException extends RuntimeException{
    public AlreadyUserException(String message) {
        super(message);
    }
}
