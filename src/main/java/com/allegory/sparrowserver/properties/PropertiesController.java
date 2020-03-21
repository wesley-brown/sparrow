package com.allegory.sparrowserver.properties;

import java.util.List;

/**
 * A REST controller for a /properties endpoint.
 */
public final class PropertiesController {
    private final List<Property> properties;

    /**
     * Create a new PropertiesController.
     *
     * @param properties the initial properties the new PropertiesController
     *                   will keep track of.
     */
    public PropertiesController(final List<Property> properties) {
        this.properties = properties;
    }

    public List<Property> properties() {
        return properties;
    }
}
