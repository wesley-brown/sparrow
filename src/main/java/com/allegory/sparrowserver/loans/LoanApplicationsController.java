package com.allegory.sparrowserver.loans;

import com.allegory.sparrowserver.customers.Customer;
import com.allegory.sparrowserver.properties.Property;
import java.util.List;

/**
 * A REST controller for loan applications endpoints.
 */
final class LoanApplicationsController {
    private List<LoanApplication> loanApplications;

    /**
     * Create a new loan applications controller.
     *
     * @param loanApplications the loan applications the new loan applications
     *                         controller will initially know about.
     */
    LoanApplicationsController(final List<LoanApplication> loanApplications) {
        this.loanApplications = loanApplications;
    }

    List<LoanApplication> loanApplications() {
        return loanApplications;
    }

    LoanApplication postLoanApplicationRequest(
            final LoanApplicationPostRequest loanApplicationRequest) {
        final Customer buyer = new Customer(loanApplicationRequest.buyer());
        final Property property =
                new Property(loanApplicationRequest.propertyAddress());

        // Currently a customer does not pick their own loan officer
        final LoanOfficer paul = new LoanOfficer("Paul", 5);
        final LoanApplication loanApplication =
                new LoanApplication(buyer, property, paul);
        return loanApplication;
    }
}
