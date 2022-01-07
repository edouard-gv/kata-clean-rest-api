package fr.arolla.kata.java.restapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DesignationController {
    @RequestMapping(value = "/etablissement/{siret}/designation/", method = RequestMethod.POST)
    public String updateDesignationForSiret(String siret, String raison_sociale, String enseigne) {
        return cleanJson("{'raison_sociale':'Arolla SAS', 'enseigne':'Arolla'}");
    }

    private static String cleanJson(String readableJSON) {
        return readableJSON.replace('\'', '"').replaceAll(", ", ",");
    }

}
