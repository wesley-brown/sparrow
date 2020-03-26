package com.allegory.sparrowserver.loans;

import com.allegory.sparrow.domain.loans.LoanOfficer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<GetLoanOfficerResponse> loanOfficers() {
        final List<LoanOfficer> loanOfficers =
            loanOfficersService.loanOfficers();
        final List<GetLoanOfficerResponse> loanOfficerResponses =
            new ArrayList<>();
        for (final LoanOfficer loanOfficer : loanOfficers) {
            final GetLoanOfficerResponse response = new GetLoanOfficerResponse(
                loanOfficer.name(),
                loanOfficer.rating()
            );
            loanOfficerResponses.add(response);
        }
        return loanOfficerResponses;
    }
}
