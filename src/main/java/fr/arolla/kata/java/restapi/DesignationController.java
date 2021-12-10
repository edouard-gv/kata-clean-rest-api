package fr.arolla.kata.java.restapi;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DesignationController {
    @RequestMapping(value = "/etablissement/{siret}/designation/", method = RequestMethod.POST)
    public Map<String, String> updateDesignationForSiret(String siret, @RequestBody Map designation) {
        return Map.of("raison_sociale", (String)designation.get("raison_sociale"), "enseigne", (String)designation.get("enseigne"));
    }

    @RequestMapping(value = "/echo/", method = RequestMethod.POST)
    public String echo(@RequestBody Map input) {
        return input.toString();
    }
}
