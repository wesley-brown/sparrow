package com.allegory.sparrowserver.customers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class CustomersTest {

    @Test
    public void two_identical_customers_have_the_same_hash_codes() {
        final Customer customerOne = new Customer("Bob");
        final Customer customerTwo = new Customer("Bob");
        assertEquals(customerOne.hashCode(), customerTwo.hashCode());
    }
}
