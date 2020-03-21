package com.allegory.sparrowserver.properties;

import java.util.List;

/**
 * A REST controller for a /properties endpoint.
 */
public final class PropertiesController {
    private final PropertiesService propertiesService;

    /**
     * Create a new PropertiesController.
     *
     * @param propertiesService the PropertiesService the new
     *                          PropertiesController will use.
     */
    public PropertiesController(final PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    public List<Property> properties() {
        return propertiesService.properties();
    }
}
