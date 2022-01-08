package fr.arolla.kata.java.restapi.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.arolla.kata.java.restapi.domain.Designation;
import fr.arolla.kata.java.restapi.domain.Siret;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatedDesignation {

    @JsonProperty("denomination_usuelle")
    public final String denominationUsuelle;
    public final String enseigne;
    public final String siret;

    private UpdatedDesignation(String siret, String denominationUsuelle, String enseigne) {
        this.siret = siret;
        this.denominationUsuelle = denominationUsuelle;
        this.enseigne = enseigne;
    }

    public static UpdatedDesignation from(Siret siret, Designation designation) {
        return new UpdatedDesignation(siret.toString(), designation.getDenominationUsuelle(), designation.getEnseigne());
    }
}
