package fr.arolla.kata.java.restapi.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignationTest {

    @Test
    public void cleanDevraitSupprimerLesAccentsDansLaDenominationUsuelle() {
        assertEquals("PasDaccent", new Designation("PasDaccent", "NA").getDenominationUsuelle());
        assertEquals("eaccenteaigu", new Designation("éaccentéaigu", "NA").getDenominationUsuelle());
    }

    @Test
    public void cleanDevraitSupprimerLesAccentsDansLEnseigne() {
        assertEquals("PasDaccent", new Designation("NA","PasDaccent").getEnseigne());
        assertEquals("eaccenteaigu", new Designation("NA","éaccentéaigu").getEnseigne());
    }
}
