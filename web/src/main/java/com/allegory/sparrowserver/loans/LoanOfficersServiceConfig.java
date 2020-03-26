package com.allegory.sparrowserver.loans;

import com.allegory.sparrow.domain.loans.LoanOfficer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for LoanOfficersService dependencies.
 */
@Configuration
class LoanOfficersServiceConfig {

    @Bean
    LoanOfficersService getLoanOfficersService() {
        return new LoanOfficersService(loanOfficers());
    }

    @Bean
    List<LoanOfficer> loanOfficers() {
        final List<LoanOfficer> loanOfficers = new ArrayList<>();
        loanOfficers.add(new LoanOfficer("Jimmy", 1));
        loanOfficers.add(new LoanOfficer("Alice", 5));
        return loanOfficers;
    }
}
