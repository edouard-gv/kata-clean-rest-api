package fr.arolla.kata.java.restapi.domain;

public interface Annuaire {
    Designation findDesignationBySiret(Siret siret);
    void storeDesignation(Siret siret, Designation designation);
}
