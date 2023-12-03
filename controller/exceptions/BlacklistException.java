package com.example.cms.controller.exceptions;

public class BlacklistException extends RuntimeException{
    public BlacklistException(String message) {
        super(message);
    }
}
