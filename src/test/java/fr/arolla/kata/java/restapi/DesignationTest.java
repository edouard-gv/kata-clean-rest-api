package fr.arolla.kata.java.restapi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DesignationTest {

    @Test
    public void cleanDevraitSupprimerLesAccentsDansLaDenominationUsuelle() {
        assertEquals("PasDaccent", new Designation("PasDaccent", "NA").getDenomination_usuelle());
        assertEquals("eaccenteaigu", new Designation("éaccentéaigu", "NA").getDenomination_usuelle());
    }

    @Test
    public void cleanDevraitSupprimerLesAccentsDansLEnseigne() {
        assertEquals("PasDaccent", new Designation("NA","PasDaccent").getEnseigne());
        assertEquals("eaccenteaigu", new Designation("NA","éaccentéaigu").getEnseigne());
    }

    @Test
    public void onDevraitRecupererDesAttributsVidesEtNonNulsQuandOnPasseDesValeursNulles() {
        assertEquals("", new Designation("*",null).getEnseigne());
        assertEquals("", new Designation(null,"*").getDenomination_usuelle());
    }
}
