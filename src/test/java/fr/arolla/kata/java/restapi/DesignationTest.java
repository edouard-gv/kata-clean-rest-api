package fr.arolla.kata.java.restapi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DesignationTest {

    @Test
    public void cleanDevraitSupprimerLesAccentsDansLaRaisonSociale() {
        assertEquals("PasDaccent", new Designation("PasDaccent", "NA").getRaisonSociale());
        assertEquals("eaccenteaigu", new Designation("éaccentéaigu", "NA").getRaisonSociale());
    }

    @Test
    public void cleanDevraitSupprimerLesAccentsDansLEnseigne() {
        assertEquals("PasDaccent", new Designation("NA","PasDaccent").getEnseigne());
        assertEquals("eaccenteaigu", new Designation("NA","éaccentéaigu").getEnseigne());
    }

    @Test
    public void onDevraitRecupererDesAttributsVidesEtNonNulsQuandOnPasseDesValeursNulles() {
        assertEquals("", new Designation("*",null).getEnseigne());
        assertEquals("", new Designation(null,"*").getRaisonSociale());
    }
}
