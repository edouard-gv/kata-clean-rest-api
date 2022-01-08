package fr.arolla.kata.java.restapi;

import java.util.HashMap;
import java.util.Map;

public class DesignationService {

    private Map<Siret, Designation> designationRepository;

    public DesignationService() {
        designationRepository = new HashMap<>();
        designationRepository.put(new Siret("12345678901234"), new Designation("Espace SAS", "Le Beau Pré"));
        designationRepository.put(new Siret("00045678901234"), new Designation("_", "_"));
    }

    public Designation updateDesignation(Siret siret, Designation targetValue) {
        if (!designationRepository.containsKey(siret)) {
            throw new InvalidDomainValueException("Siret unknown "+ siret);
            // @TODO : add unit test
        }

        Designation oldDesignation = designationRepository.get(siret);

        Designation newDesignation = new Designation(
                targetValue.getDenominationUsuelle() != null ? targetValue.getDenominationUsuelle() : oldDesignation.getDenominationUsuelle(),
                targetValue.getEnseigne() != null ? targetValue.getEnseigne() : oldDesignation.getEnseigne()
        );

        designationRepository.put(siret, newDesignation);

        return newDesignation;
    }


}
