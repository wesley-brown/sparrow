package com.allegory.sparrowserver.customers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CustomersTest {
    private Customer bob;

    @BeforeEach
    private void setUp() {
        bob = new Customer("Bob");
    }

    @AfterEach
    private void tearDown() {
        bob = null;
    }

    @Test
    public void two_identical_customers_have_the_same_hash_codes() {
        final Customer bobsClone = new Customer("Bob");
        assertEquals(bob.hashCode(), bobsClone.hashCode());
    }

    @Test
    public void two_identical_customers_should_be_equal() {
        final Customer bobsClone = new Customer("Bob");
        assertEquals(bob, bobsClone);
    }
}
