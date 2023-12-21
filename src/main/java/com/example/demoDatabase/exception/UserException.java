package com.example.demoDatabase.exception;

public class UserException extends RuntimeException {
    public UserException(String str) {
        // calling the constructor of parent Exception
        super(str);
    }
}