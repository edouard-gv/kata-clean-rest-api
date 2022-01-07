package fr.arolla.kata.java.restapi;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


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
                        null,
                        String.class);

        JSONAssert.assertEquals(cleanJson("{'denomination_usuelle':'Arolla SAS', 'enseigne':'Arolla'}"),
                response, false);
    }

    private static String cleanJson(String readableJSON) {
        return readableJSON.replace('\'', '"').replaceAll(", ", ",");
    }

}


