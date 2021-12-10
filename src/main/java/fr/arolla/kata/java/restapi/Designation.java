package fr.arolla.kata.java.restapi;

public class Designation {
    public String getDenomination_usuelle() {
        return safeString(denomination_usuelle);
    }

    public String getEnseigne() {
        return safeString(enseigne);
    }

    private String safeString(String attribute) {
        return attribute == null? "": attribute;
    }

    private final String denomination_usuelle;
    private final String enseigne;

    public Designation(String denomination_usuelle, String enseigne) {
        this.denomination_usuelle = clean(denomination_usuelle);
        this.enseigne = clean(enseigne);
    }

    private String clean(String input) {
        return (input == null ? null : input.replaceAll("é", "e"));
    }
}
