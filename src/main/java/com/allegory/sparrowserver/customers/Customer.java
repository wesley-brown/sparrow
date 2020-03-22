package com.allegory.sparrowserver.customers;

/**
 * A customer.
 */
public final class Customer {
    private final String name;

    /**
     * Create a new Customer.
     *
     * @param name the name of the new Customer.
     */
    public Customer(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = name.hashCode();
        return result;
    }
}
