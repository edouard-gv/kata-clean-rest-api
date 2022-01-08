package fr.arolla.kata.java.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DesignationController {

    @PatchMapping(value = "/etablissement/{siret}/designation/")
    public ResponseEntity<UpdatedDesignation> updateDesignationForSiret(@PathVariable Siret siret, @RequestBody Designation designation) {
        return ResponseEntity.ok(UpdatedDesignation.from(siret, new DesignationService().updateDesignation(siret, designation)));
    }

    @RequestMapping(value = "/echo/", method = RequestMethod.POST)
    public String echo(@RequestBody Map input) {
        return input.toString();
    }
}
