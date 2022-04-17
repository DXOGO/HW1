package com.dxogo.hw1.exception;

public class APINotRespondingException extends Exception {
    public APINotRespondingException(String errorMessage) { super(errorMessage); }
}
