package fr.arolla.kata.java.restapi.domain;

import fr.arolla.kata.java.restapi.api.SiretConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SiretParsingTest {
    @Test
    public void laConstructionDevraitAjouterDesZeros() {
        assertEquals("12345678901234", new Siret("12345678901234").toString());
        assertEquals("00045678901234", new Siret(   "45678901234").toString());
    }

    @Test
    public void laConversionDevraitEnleverLesTirets() {
        assertEquals("12345678901234", new SiretConverter().convert("12345678901234").toString());
        assertEquals("12345678901234", new SiretConverter().convert("123-456-789-01234").toString());
    }
}
