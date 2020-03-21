package com.allegory.sparrowserver.properties;

import java.util.List;

final class PropertiesService {
    private final List<Property> properties;

    PropertiesService(final List<Property> properties) {
        this.properties = properties;
    }

    List<Property> properties() {
        return properties;
    }
}
