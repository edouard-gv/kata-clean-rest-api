package fr.arolla.kata.java.restapi;

public class Designation {
    public String getRaisonSociale() {
        return safeString(raisonSociale);
    }

    public String getEnseigne() {
        return safeString(enseigne);
    }

    private String safeString(String attribute) {
        return attribute == null? "": attribute;
    }

    private final String raisonSociale;
    private final String enseigne;

    public Designation(String raisonSociale, String enseigne) {
        this.raisonSociale = clean(raisonSociale);
        this.enseigne = clean(enseigne);
    }

    private String clean(String input) {
        return (input == null ? null : input.replaceAll("é", "e"));
    }
}
