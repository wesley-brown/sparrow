package com.allegory.sparrowserver.loans;

import com.allegory.sparrow.domain.customers.Customer;
import com.allegory.sparrow.domain.loans.LoanOfficer;
import com.allegory.sparrow.domain.properties.Property;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller for loan applications endpoints.
 */
@RestController
final class LoanApplicationsController {
    private List<LoanApplication> loanApplications;

    /**
     * Create a new loan applications controller.
     *
     * @param loanApplications the loan applications the new loan applications
     *                         controller will initially know about.
     */
    @Autowired
    LoanApplicationsController(final List<LoanApplication> loanApplications) {
        this.loanApplications = loanApplications;
    }

    List<LoanApplication> loanApplications() {
        return loanApplications;
    }

    @PostMapping("/api/v1/loan-applications")
    LoanApplicationResponse postLoanApplicationRequest(
        @RequestBody final PostLoanApplicationRequest loanApplicationRequest) {
        final Customer buyer = new Customer(loanApplicationRequest.buyer());
        final Property property =
            new Property(loanApplicationRequest.propertyAddress());

        // Currently a customer does not pick their own loan officer
        final LoanOfficer paul = new LoanOfficer("Paul", 5);
        final LoanApplication loanApplication =
            new LoanApplication(buyer, property, paul);
        return new LoanApplicationResponse(
            loanApplication.buyer().name(),
            loanApplication.property().address(),
            loanApplication.loanOfficer().name()
        );
    }
}
