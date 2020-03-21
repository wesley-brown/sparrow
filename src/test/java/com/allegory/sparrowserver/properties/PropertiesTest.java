package com.allegory.sparrowserver.properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class PropertiesTest {

    @Test
    public void two_identical_properties_have_the_same_hashcode() {
        final Property propertyOne = new Property("123 Main St");
        final Property propertyTwo = new Property("123 Main St");
        assertEquals(propertyOne.hashCode(), propertyTwo.hashCode());
    }
}
