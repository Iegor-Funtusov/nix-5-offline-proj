package com.nix.module_2.dates;

public class DateException extends RuntimeException {

    public DateException(String msg) {
        super(msg);
    }

    public DateException() {
        super("Invalid date");
    }
}
