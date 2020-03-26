package com.allegory.sparrowserver.loans;

import com.allegory.sparrow.domain.customers.Customer;
import com.allegory.sparrow.domain.properties.Property;

/**
 * A loan application.
 */
public final class LoanApplication {
    private final Customer buyer;
    private final Property property;
    private final LoanOfficer loanOfficer;

    /**
     * Create a new loan application.
     *
     * @param buyer the customer applying for a loan.
     * @param property the property the customer needs a loan for.
     * @param loanOfficer the loan officer who can help the customer with the
     *                    loan.
     */
    public LoanApplication(final Customer buyer,
                           final Property property,
                           final LoanOfficer loanOfficer) {
        this.buyer = buyer;
        this.property = property;
        this.loanOfficer = loanOfficer;
    }

    public Customer buyer() {
        return buyer;
    }

    public Property property() {
        return property;
    }

    public LoanOfficer loanOfficer() {
        return loanOfficer;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = buyer.hashCode();
        result = 31 * result * property.hashCode();
        result = 31 * result * loanOfficer.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof LoanApplication)) {
            return false;
        }

        final LoanApplication loanApplication = (LoanApplication) other;
        return (loanApplication.buyer.equals(this.buyer))
                && (loanApplication.property.equals(this.property))
                && (loanApplication.loanOfficer.equals(this.loanOfficer));
    }

    @Override
    public String toString() {
        return "<buyer=" + buyer + ", property=" + property + ", loan officer="
                + loanOfficer + ">";
    }
}
