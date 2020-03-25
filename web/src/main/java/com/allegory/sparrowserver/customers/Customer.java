package com.allegory.sparrowserver.customers;

import com.allegory.sparrow.domain.properties.Property;
import com.allegory.sparrowserver.loans.LoanApplication;
import com.allegory.sparrowserver.loans.LoanOfficer;
import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty
    public String name() {
        return name;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = name.hashCode();
        return result;
    }

    /**
     * Apply for a property loan through a given loan officer.
     *
     * @param property    the property to apply for a loan for.
     * @param loanOfficer the loan officer to apply for a loan through.
     * @return the loan application applied for.
     */
    public LoanApplication applyForLoan(
            final Property property,
            final LoanOfficer loanOfficer) {
        return new LoanApplication(this, property, loanOfficer);
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
