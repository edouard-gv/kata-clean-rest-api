package fr.arolla.kata.java.restapi.repository;

import fr.arolla.kata.java.restapi.domain.Annuaire;
import fr.arolla.kata.java.restapi.domain.Designation;
import fr.arolla.kata.java.restapi.domain.InvalidDomainValueException;
import fr.arolla.kata.java.restapi.domain.Siret;

import java.util.HashMap;
import java.util.Map;

public class AnnuaireInMemory implements Annuaire {
    Map<Siret, Designation> designationRepository;

    public AnnuaireInMemory() {
        designationRepository = new HashMap<>();
        storeDesignation(new Siret("12345678901234"), new Designation("Espace SAS", "Le Beau Pré"));
        storeDesignation(new Siret("00045678901234"), new Designation("_", "_"));

    }

    @Override
    public void storeDesignation(Siret siret, Designation newDesignation) {
        designationRepository.put(siret, newDesignation);
    }

    @Override
    public Designation findDesignationBySiret(Siret siret) {
        if (!designationRepository.containsKey(siret)) {
            throw new InvalidDomainValueException("Siret unknown " + siret);
        }

        return designationRepository.get(siret);
    }
}