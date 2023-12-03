package com.example.cms.controller.exceptions;

public class BlacklistNotFoundException  extends RuntimeException{
    public BlacklistNotFoundException(long blacklistId){super("could not find user"+blacklistId);};
}
