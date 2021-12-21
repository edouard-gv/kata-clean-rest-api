package fr.arolla.kata.java.restapi;

public class Designation {
    public String getDenominationUsuelle() {
        return safeString(denominationUsuelle);
    }

    public String getEnseigne() {
        return safeString(enseigne);
    }

    private String safeString(String attribute) {
        return attribute == null? "": attribute;
    }

    private final String denominationUsuelle;
    private final String enseigne;

    public Designation(String denominationUsuelle, String enseigne) {
        this.denominationUsuelle = clean(denominationUsuelle);
        this.enseigne = clean(enseigne);
    }

    private String clean(String input) {
        return (input == null ? null : input.replaceAll("é", "e"));
    }
}
