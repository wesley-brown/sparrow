package com.allegory.sparrow.domain.customers;

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

    public String name() {
        return name;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = name.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Customer)) {
            return false;
        }

        final Customer customer = (Customer) other;
        return customer.name.equals(this.name);
    }

    @Override
    public String toString() {
        return "<name=" + name + ">";
    }
}
