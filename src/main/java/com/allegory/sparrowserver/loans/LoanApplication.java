package com.allegory.sparrowserver.loans;

import com.allegory.sparrowserver.customers.Customer;
import com.allegory.sparrowserver.properties.Property;

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

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = buyer.hashCode();
        result = 31 * result * property.hashCode();
        result = 31 * result * loanOfficer.hashCode();
        return result;
    }
}
