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
                        .content(cleanJson("{'raison_sociale':'Nature SAS', 'enseigne':'Le Joli Pré'}"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(cleanJson("{'raison_sociale':'Nature SAS', 'enseigne':'Le Joli Pre'}")));
    }

    private static String cleanJson(String readableJSON) {
        return readableJSON.replace('\'', '"').replaceAll(", ", ",");
    }

}
