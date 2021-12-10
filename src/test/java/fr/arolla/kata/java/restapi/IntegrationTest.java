package fr.arolla.kata.java.restapi;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    public void appelerLAPIdUpdateDevraitRenvoyerLaDesignation() throws JSONException {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        String response = testRestTemplate.
                postForObject("http://localhost:" + this.port + "/etablissement/12345678901234/designation/",
                        Map.of("denomination_usuelle", "Arolla SAS", "enseigne", "Arolla"),
                        String.class);

        JSONAssert.assertEquals(cleanJson("{'denomination_usuelle':'Arolla SAS', 'enseigne':'Arolla'}"),
                response, false);
    }


    @Test
    public void appelerLAPIdUpdateDevraitRenvoyerLaDesignationEnPassantParLeConstructeurQuiNettoieLesAccents() throws JSONException {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        String response = testRestTemplate.
                postForObject("http://localhost:" + this.port + "/etablissement/12345678901234/designation/",
                        Map.of("denomination_usuelle", "Nature SAS", "enseigne", "Le Joli Pré"),
                        String.class);

        JSONAssert.assertEquals(cleanJson("{'denomination_usuelle':'Nature SAS', 'enseigne':'Le Joli Pre'}"),
                response, false);
    }

    private static String cleanJson(String readableJSON) {
        return readableJSON.replace('\'', '"').replaceAll(", ", ",");
    }

    @Test
    public void echoMap() {
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        String response = testRestTemplate.
                postForObject("http://localhost:" + this.port + "/echo/",
                        Map.of("input", "Arolla SAS", "enseigne", "Arolla"),
                        String.class);

        assertTrue("{enseigne=Arolla, input=Arolla SAS}".equals(response) || "{input=Arolla SAS, enseigne=Arolla}".equals(response));
    }

}


