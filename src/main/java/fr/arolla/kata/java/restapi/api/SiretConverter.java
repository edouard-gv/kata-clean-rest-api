package fr.arolla.kata.java.restapi.api;

import fr.arolla.kata.java.restapi.domain.Siret;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SiretConverter implements Converter<String, Siret> {

    @Override
    public Siret convert(String input) {
        return new Siret(input.replace("-", ""));
    }
}