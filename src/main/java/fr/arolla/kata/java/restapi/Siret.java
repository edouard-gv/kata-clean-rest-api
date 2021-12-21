package fr.arolla.kata.java.restapi;

public class Siret {

    private String siret;

    public Siret(String siret) {
        this.siret = String.format("%1$14s", siret).replace(' ', '0');
    }

    @Override
    public String toString() {
        return siret;

    }
}
