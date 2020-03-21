package com.allegory.sparrowserver.loans;

import java.util.List;

/**
 * A REST controller for loan officers endpoints.
 */
public final class LoanOfficersController {
    private final LoanOfficersService loanOfficersService;

    /**
     * Create a new LoanOfficersController.
     *
     * @param loanOfficersService the loan officers service the new
     *                            LoanOfficersController will use.
     */
    public LoanOfficersController(final LoanOfficersService loanOfficersService) {
        this.loanOfficersService = loanOfficersService;
    }

    public List<LoanOfficer> loanOfficers() {
        return loanOfficersService.loanOfficers();
    }
}
