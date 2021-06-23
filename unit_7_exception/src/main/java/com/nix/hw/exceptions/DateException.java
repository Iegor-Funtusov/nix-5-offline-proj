package com.nix.hw.exceptions;

public class DateException extends RuntimeException {

    public DateException(String msg) {
        super(msg);
    }

    public DateException() {
        super("Invalid date");
    }
}
