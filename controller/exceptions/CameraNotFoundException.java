package com.example.cms.controller.exceptions;


public class CameraNotFoundException extends RuntimeException{
    public CameraNotFoundException(long cid) {
            super("Could not find camera no. " + cid);
        }
}

