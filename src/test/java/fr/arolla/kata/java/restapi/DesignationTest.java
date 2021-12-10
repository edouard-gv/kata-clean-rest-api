package fr.arolla.kata.java.restapi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DesignationTest {

    @Test
    public void cleanDevraitSupprimerLesAccentsDansLaRaisonSociale() {
        assertEquals("PasDaccent", new Designation("PasDaccent", "NA").getRaison_sociale());
        assertEquals("eaccenteaigu", new Designation("éaccentéaigu", "NA").getRaison_sociale());
    }

    @Test
    public void cleanDevraitSupprimerLesAccentsDansLEnseigne() {
        assertEquals("PasDaccent", new Designation("NA","PasDaccent").getEnseigne());
        assertEquals("eaccenteaigu", new Designation("NA","éaccentéaigu").getEnseigne());
    }
}
