package fr.arolla.kata.java.restapi.domain;

public class UnknownEntityException extends RuntimeException {

    private final String code;

    public UnknownEntityException(String code, String message) {
        super(message);
        this.code = code;
    }

    public UnknownEntityException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
