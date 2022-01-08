package fr.arolla.kata.java.restapi.api;

import fr.arolla.kata.java.restapi.domain.Annuaire;
import fr.arolla.kata.java.restapi.domain.Designation;
import fr.arolla.kata.java.restapi.domain.DesignationService;
import fr.arolla.kata.java.restapi.domain.Siret;
import fr.arolla.kata.java.restapi.repository.AnnuaireInMemory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DesignationController {

    @PatchMapping(value = "/etablissement/{siret}/designation/")
    public ResponseEntity<UpdatedDesignation> updateDesignationForSiret(@PathVariable Siret siret, @RequestBody Designation designation) {
        Annuaire annuaire = new AnnuaireInMemory();
        return ResponseEntity.ok(UpdatedDesignation.from(siret, new DesignationService(annuaire).updateDesignation(siret, designation)));
    }

    @RequestMapping(value = "/echo/", method = RequestMethod.POST)
    public String echo(@RequestBody Map<String, Object> input) {
        return input.toString();
    }
}
