package com.allegory.sparrowserver.loans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A REST controller for loan officers endpoints.
 */
@RestController
public final class LoanOfficersController {
    private final LoanOfficersService loanOfficersService;

    /**
     * Create a new LoanOfficersController.
     *
     * @param loanOfficersService the loan officers service the new
     *                            LoanOfficersController will use.
     */
    @Autowired
    public LoanOfficersController(final LoanOfficersService loanOfficersService) {
        this.loanOfficersService = loanOfficersService;
    }

    @GetMapping("/api/v1/loan-officers")
    public List<LoanOfficer> loanOfficers() {
        return loanOfficersService.loanOfficers();
    }
}
