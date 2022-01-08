package fr.arolla.kata.java.restapi.domain;

public class Designation {
    public String getDenominationUsuelle() {
        return denominationUsuelle;
    }

    public String getEnseigne() {
        return enseigne;
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
