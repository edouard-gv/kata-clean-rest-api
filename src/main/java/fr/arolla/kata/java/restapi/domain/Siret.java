package fr.arolla.kata.java.restapi.domain;

import java.util.Objects;

public class Siret {

    private String siret;

    public Siret(String siret) {
        this.siret = String.format("%1$14s", siret).replace(' ', '0');
    }

    @Override
    public String toString() {
        return siret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Siret siret1 = (Siret) o;
        return siret.equals(siret1.siret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siret);
    }
}
