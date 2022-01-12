package fr.arolla.kata.java.restapi.api;

import fr.arolla.kata.java.restapi.domain.UnknownEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(UnknownEntityException.class)
    public ResponseEntity<DomainExceptionMessage> handleInvalidDomainValueException(UnknownEntityException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DomainExceptionMessage(ex.getCode(), ex.getMessage()));
    }
}
