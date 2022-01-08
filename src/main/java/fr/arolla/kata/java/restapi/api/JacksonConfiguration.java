package fr.arolla.kata.java.restapi.api;

import fr.arolla.kata.java.restapi.domain.Designation;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> builder
                .mixIn(Designation.class, DesignationMixin.class);
    }
}
