package com.allegory.sparrowserver.properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
