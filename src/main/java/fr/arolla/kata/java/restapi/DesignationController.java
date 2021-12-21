package fr.arolla.kata.java.restapi;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DesignationController {
    @RequestMapping(value = "/etablissement/{siret}/designation/", method = RequestMethod.POST)
    public Map<String, String> updateDesignationForSiret(@PathVariable Siret siret, @RequestBody Designation designation) {
        return Map.of( "siret", siret.toString(), "denomination_usuelle", designation.getDenominationUsuelle(), "enseigne", designation.getEnseigne());
    }

    @RequestMapping(value = "/echo/", method = RequestMethod.POST)
    public String echo(@RequestBody Map input) {
        return input.toString();
    }
}
