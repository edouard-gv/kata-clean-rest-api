package fr.arolla.kata.java.restapi.domain;

public class DesignationService {

    private final Annuaire annuaire;

    public DesignationService(Annuaire annuaire) {
        this.annuaire = annuaire;
    }

    public Designation updateDesignation(Siret siret, Designation targetValue) {
        Designation oldDesignation = annuaire.findDesignationBySiret(siret);

        Designation newDesignation = new Designation(
                targetValue.getDenominationUsuelle() != null ? targetValue.getDenominationUsuelle() : oldDesignation.getDenominationUsuelle(),
                targetValue.getEnseigne() != null ? targetValue.getEnseigne() : oldDesignation.getEnseigne()
        );

        annuaire.storeDesignation(siret, newDesignation);

        return newDesignation;
    }
}
