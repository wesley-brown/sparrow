package com.allegory.sparrowserver.loans;

import com.allegory.sparrow.domain.loans.LoanOfficer;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * A service that provides loan officers.
 */
@Service
final class LoanOfficersService {
    private final List<LoanOfficer> loanOfficers;

    /**
     * Create a new LoanOfficersService.
     *
     * @param loanOfficers the initial loan officers the new
     *                     LoanOfficersService will provide.
     */
    LoanOfficersService(final List<LoanOfficer> loanOfficers) {
        this.loanOfficers = loanOfficers;
    }

    List<LoanOfficer> loanOfficers() {
        return loanOfficers;
    }
}
