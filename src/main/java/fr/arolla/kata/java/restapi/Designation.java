package fr.arolla.kata.java.restapi;

public class Designation {
    public String getRaison_sociale() {
        return safeString(raison_sociale);
    }

    public String getEnseigne() {
        return safeString(enseigne);
    }

    private String safeString(String attribute) {
        return attribute == null? "": attribute;
    }

    private final String raison_sociale;
    private final String enseigne;

    public Designation(String raison_sociale, String enseigne) {
        this.raison_sociale = clean(raison_sociale);
        this.enseigne = clean(enseigne);
    }

    private String clean(String input) {
        return (input == null ? null : input.replaceAll("é", "e"));
    }
}
