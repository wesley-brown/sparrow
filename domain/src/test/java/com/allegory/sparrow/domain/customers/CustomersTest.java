package com.allegory.sparrow.domain.customers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CustomersTest {
    private Customer bob;

    @BeforeEach
    void setUp() {
        bob = new Customer("Bob");
    }

    @AfterEach
    void tearDown() {
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
