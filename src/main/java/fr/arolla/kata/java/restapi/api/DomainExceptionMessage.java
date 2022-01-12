package fr.arolla.kata.java.restapi.api;

public class DomainExceptionMessage {
    public final String code;
    public final String message;

    public DomainExceptionMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
