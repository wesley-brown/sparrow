package com.allegory.sparrowserver.loans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class LoansTest {

    @Test
    public void two_identical_loan_officers_have_the_same_hash_code() {
        final LoanOfficer loanOfficerOne = new LoanOfficer("Jimmy", 1);
        final LoanOfficer loanOfficerTwo = new LoanOfficer("Jimmy", 1);
        assertEquals(loanOfficerOne.hashCode(), loanOfficerTwo.hashCode());
    }
}
