package com.allegory.sparrowserver.properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.properties.Property;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class PropertiesTest {
    private GetPropertyResponse houseJimmyWants;
    private GetPropertyResponse houseSallyWants;

    @BeforeEach
    public void setUp() {
        houseJimmyWants = new GetPropertyResponse("123 Main St");
        houseSallyWants = new GetPropertyResponse("123 Main St");
    }

    @AfterEach
    public void tearDown() {
        houseJimmyWants = null;
        houseSallyWants = null;
    }

    @Test
    public void two_identical_get_property_responses_have_the_same_hash_codes() {
        assertEquals(houseJimmyWants.hashCode(), houseSallyWants.hashCode());
    }

    @Test
    public void two_identical_get_property_responses_are_equal() {
        assertEquals(houseJimmyWants, houseSallyWants);
    }

    @Test
    public void getting_all_properties_returns_all_properties() {
        final List<Property> initialProperties = new ArrayList<>();
        initialProperties.add(new Property(houseJimmyWants.propertyAddress()));
        initialProperties.add(new Property("456 Second St"));

        final PropertiesService propertiesService =
                new PropertiesService(initialProperties);
        final PropertiesController propertiesController =
                new PropertiesController(propertiesService);
        final List<GetPropertyResponse> availableProperties =
                propertiesController.properties();

        final List<GetPropertyResponse> expectedProperties = new ArrayList<>();
        expectedProperties.add(houseJimmyWants);
        expectedProperties.add(new GetPropertyResponse("456 Second St"));
        assertThat(availableProperties).containsExactlyInAnyOrderElementsOf(
                expectedProperties);
    }
}
