package com.example.cms.controller.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public  AccountNotFoundException(Long uid){super("could not find user"+uid);};
}
