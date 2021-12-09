package com.test.exceptions;

public class BadRequestException extends Exception{
    public BadRequestException() {}

    public BadRequestException(String massage) {
        super(massage);
    }
}
