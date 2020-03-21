package com.allegory.sparrowserver.loans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class LoansTest {

    private LoanOfficer loanOfficerOne;

    @BeforeEach
    public void setUp() {
        loanOfficerOne = new LoanOfficer("Jimmy", 1);
    }

    @AfterEach
    public void tearDown() {
        loanOfficerOne = null;
    }

    @Test
    public void two_identical_loan_officers_have_the_same_hash_code() {
        final LoanOfficer loanOfficerTwo = new LoanOfficer("Jimmy", 1);
        assertEquals(loanOfficerOne.hashCode(), loanOfficerTwo.hashCode());
    }

    @Test
    public void two_identical_loan_officer_are_equal() {
        final LoanOfficer loanOfficerTwo = new LoanOfficer("Jimmy", 1);
        assertEquals(loanOfficerOne, loanOfficerTwo);
    }
}
