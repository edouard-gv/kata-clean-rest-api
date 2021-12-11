package fr.arolla.kata.java.restapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class DesignationController {
    @RequestMapping(value = "/etablissement/{siret}/designation/", method = RequestMethod.POST)
    public Map<String, String> updateDesignationForSiret(String siret, @RequestBody Designation designation) {
        return Map.of("raison_sociale", designation.getRaisonSociale(), "enseigne", designation.getEnseigne());
    }

    @RequestMapping(value = "/echo/", method = RequestMethod.POST)
    public String echo(@RequestBody Map input) {
        return input.toString();
    }

    @Bean
    public HttpMessageConverter<Object> createJsonToDesignationConverter() {
        return converterWithDeserializerForType(Designation.class, new JsonDeserializer<>() {
            @Override
            public Designation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                JsonNode node = jsonParser.getCodec().readTree(jsonParser);
                return new Designation(node.get("raison_sociale").asText(), node.get("enseigne").asText());
            }
        });
    }

    private static <T> MappingJackson2HttpMessageConverter converterWithDeserializerForType(Class<T> type, JsonDeserializer<T> jsonDeserializer) {
        return new MappingJackson2HttpMessageConverter(
                Jackson2ObjectMapperBuilder.json().build().registerModule(
                        new SimpleModule().addDeserializer(type,
                                jsonDeserializer)
                )
        );
    }
}
