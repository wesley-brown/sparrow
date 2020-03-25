package com.allegory.sparrowserver.properties;

import com.allegory.sparrow.domain.properties.Property;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller for a /properties endpoint.
 */
@RestController
public final class PropertiesController {
    private final PropertiesService propertiesService;

    /**
     * Create a new PropertiesController.
     *
     * @param propertiesService the PropertiesService the new
     *                          PropertiesController will use.
     */
    @Autowired
    public PropertiesController(final PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping("/api/v1/properties")
    public List<GetPropertyResponse> properties() {
        final List<Property> properties = propertiesService.properties();
        final List<GetPropertyResponse> propertyResponses = new ArrayList<>();
        for (final Property property : properties) {
            propertyResponses.add(new GetPropertyResponse(property.address()));
        }
        return propertyResponses;
    }
}
