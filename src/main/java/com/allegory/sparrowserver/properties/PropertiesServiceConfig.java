package com.allegory.sparrowserver.properties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for PropertiesService dependencies.
 */
@Configuration
class PropertiesServiceConfig {

    @Bean
    PropertiesService getPropertiesService() {
        return new PropertiesService(properties());
    }

    @Bean
    List<Property> properties() {
        final List<Property> properties = new ArrayList<>();
        properties.add(new Property("123 Main St"));
        properties.add(new Property("456 First St"));
        return properties;
    }
}
