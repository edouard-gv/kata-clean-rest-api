package fr.arolla.kata.java.restapi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;

@Configuration
public class JacksonConfiguration {

    @Bean
    public HttpMessageConverter<Object> createJsonToDesignationConverter() {
        return converterWithDeserializerForType(Designation.class, new JsonDeserializer<>() {
            @Override
            public Designation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                JsonNode node = jsonParser.getCodec().readTree(jsonParser);
                return new Designation(node.get("denomination_usuelle").asText(), node.get("enseigne").asText());
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
