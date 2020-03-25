package com.allegory.sparrowserver.properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class PropertiesTest {

    private Property propertyOne;

    @BeforeEach
    public void setUp() {
        propertyOne = new Property("123 Main St");
    }

    @AfterEach
    public void tearDown() {
        propertyOne = null;
    }

    @Test
    public void two_identical_properties_have_the_same_hashcode() {
        final Property propertyTwo = new Property("123 Main St");
        assertEquals(propertyOne.hashCode(), propertyTwo.hashCode());
    }

    @Test
    public void two_identical_properties_are_equal() {
        final Property propertyTwo = new Property("123 Main St");
        assertEquals(propertyOne, propertyTwo);
    }

    @Test
    public void two_identical_get_property_responses_have_the_same_hash_codes() {
        final GetPropertyResponse house =
                new GetPropertyResponse("345 First St");
        final GetPropertyResponse duplicateHouse =
                new GetPropertyResponse("345 First St");
        assertEquals(house.hashCode(), duplicateHouse.hashCode());
    }

    @Test
    public void getting_all_properties_returns_all_properties() {
        final List<Property> initialProperties = new ArrayList<>();
        initialProperties.add(propertyOne);
        initialProperties.add(new Property("345 First St"));

        final PropertiesService propertiesService =
                new PropertiesService(initialProperties);
        final PropertiesController propertiesController =
                new PropertiesController(propertiesService);
        final List<Property> receivedProperties =
                propertiesController.properties();
        assertThat(receivedProperties).containsExactlyInAnyOrderElementsOf(
                initialProperties);
    }
}
