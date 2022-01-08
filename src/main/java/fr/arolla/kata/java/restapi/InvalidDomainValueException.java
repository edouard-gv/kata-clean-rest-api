package fr.arolla.kata.java.restapi;

public class InvalidDomainValueException extends RuntimeException {
    public InvalidDomainValueException(String message) {
        super(message);
    }

    public InvalidDomainValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
