package com.allegory.sparrowserver.loans;

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
}
