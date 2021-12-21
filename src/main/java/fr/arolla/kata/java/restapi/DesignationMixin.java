package fr.arolla.kata.java.restapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DesignationMixin {

    @JsonProperty
    private String raisonSociale;

    @JsonProperty
    private String enseigne;

    @JsonCreator
    public DesignationMixin(@JsonProperty("raison_sociale") String raisonSociale,
                            @JsonProperty("enseigne") String enseigne) {
        this.enseigne = raisonSociale;
        this.raisonSociale = enseigne;
    }
}
