package fr.arolla.kata.java.restapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LightIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void appelerLAPIdUpdateDevraitRenvoyerLaDesignationEnPassantParLeConstructeurQuiNettoieLesAccents() throws Exception {
        mockMvc.perform(post(
                        "/etablissement/12345678901234/designation/")
                        .content(cleanJson("{'denomination_usuelle':'Nature SAS', 'enseigne':'Le Joli Pré'}"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(cleanJson("{'denomination_usuelle':'Nature SAS', 'enseigne':'Le Joli Pre'}")));
    }

    @Test
    public void appelerLAPIneDevraitPasChangerLEnseigneSiOnNeLaPrecisePas() throws Exception {
        mockMvc.perform(post(
                        "/etablissement/12345678901234/designation/")
                        .content(cleanJson("{'denomination_usuelle':'Nature SAS'}"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(cleanJson("{'denomination_usuelle':'Nature SAS', 'enseigne':'Le Beau Pre'}")));
    }

    @Test
    public void appelerLAPIneDevraitPasChangerLEnseigneNiLaDesignationSiOnNeLesPrecisePas() throws Exception {
        mockMvc.perform(post(
                        "/etablissement/12345678901234/designation/")
                        .content(cleanJson("{}"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(cleanJson("{'denomination_usuelle':'Espace SAS', 'enseigne':'Le Beau Pre'}")));
    }

    @Test
    public void appelerLAPIdUpdateDevraitRenvoyerUnSiretConvertiEtConstruit() throws Exception {
        mockMvc.perform(post(
                        "/etablissement/456-789-01234/designation/")
                        .content(cleanJson("{'denomination_usuelle':'Nature SAS', 'enseigne':'Le Joli Pré'}"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(cleanJson("{'siret':'00045678901234'}")));
    }

    private static String cleanJson(String readableJSON) {
        return readableJSON.replace('\'', '"').replaceAll(", ", ",");
    }

}
