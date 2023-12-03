package com.example.cms.controller.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(long pid) {
        super("Product not found with ID: " + pid);
    }
}