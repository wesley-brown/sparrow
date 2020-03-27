package com.allegory.sparrow.domain.properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class PropertiesTest {
    private Property houseBobWants;
    private Property houseAliceWants;

    @BeforeEach
    void setUp() {
        houseBobWants = new Property("123 Main St");
        houseAliceWants = new Property("123 Main St");
    }

    @AfterEach
    void tearDown() {
        houseBobWants = null;
        houseAliceWants = null;
    }

    @Test
    public void two_identical_properties_have_the_same_hash_code() {
        assertEquals(houseBobWants.hashCode(), houseAliceWants.hashCode());
    }

    @Test
    public void two_identical_properties_are_equal() {
        assertEquals(houseBobWants, houseAliceWants);
    }
}
