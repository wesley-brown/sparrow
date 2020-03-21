package com.allegory.sparrowserver.loans;

import java.util.List;

/**
 * A REST controller for loan officers endpoints.
 */
public final class LoanOfficersController {
    private final List<LoanOfficer> loanOfficers;

    /**
     * Create a new LoanOfficersController.
     *
     * @param loanOfficers the initial loan officers the new
     *                     LoanOfficersController will know about.
     */
    public LoanOfficersController(final List<LoanOfficer> loanOfficers) {
        this.loanOfficers = loanOfficers;
    }

    public List<LoanOfficer> loanOfficers() {
        return loanOfficers;
    }
}
