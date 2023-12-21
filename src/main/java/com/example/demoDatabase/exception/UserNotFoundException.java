package com.example.demoDatabase.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}