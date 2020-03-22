package com.allegory.sparrowserver.customers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CustomersTest {
    private Customer customerOne;
    private Customer customerTwo;

    @BeforeEach
    private void setUp() {
        customerOne = new Customer("Bob");
        customerTwo = new Customer("Bob");
    }

    @AfterEach
    private void tearDown() {
        customerOne = null;
        customerTwo = null;
    }

    @Test
    public void two_identical_customers_have_the_same_hash_codes() {
        assertEquals(customerOne.hashCode(), customerTwo.hashCode());
    }

    @Test
    public void two_identical_customers_should_be_equal() {
        assertEquals(customerOne, customerTwo);
    }
}
