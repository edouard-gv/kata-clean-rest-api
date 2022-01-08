package fr.arolla.kata.java.restapi.api;

import fr.arolla.kata.java.restapi.domain.InvalidDomainValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(InvalidDomainValueException.class)
    public ResponseEntity<String> handleInvalidDomainValueException(InvalidDomainValueException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
