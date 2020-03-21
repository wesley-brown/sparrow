package com.allegory.sparrowserver.properties;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * A service that provides properties.
 */
@Service
final class PropertiesService {
    private final List<Property> properties;

    /**
     * Create a new PropertiesService.
     *
     * @param properties The initial properties the new PropertiesService will
     *                   provide.
     */
    PropertiesService(final List<Property> properties) {
        this.properties = properties;
    }

    List<Property> properties() {
        return properties;
    }
}
