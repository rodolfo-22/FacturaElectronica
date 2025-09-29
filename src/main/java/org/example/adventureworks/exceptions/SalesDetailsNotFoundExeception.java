package org.example.adventureworks.exceptions;

public class SalesDetailsNotFoundExeception extends RuntimeException {
    public SalesDetailsNotFoundExeception(String message) {
        super(message);
    }
}
