package fr.arolla.kata.java.restapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//Only annotations will to be "added" to target's annotations as value. Code doesn't count.
public class DesignationMixin {

    @JsonProperty
    private String denominationUsuelle;

    @JsonProperty
    private String enseigne;

    @JsonCreator
    public DesignationMixin(@JsonProperty("denomination_usuelle") String denominationUsuelle,
                            @JsonProperty("enseigne") String enseigne) {
    }
}
