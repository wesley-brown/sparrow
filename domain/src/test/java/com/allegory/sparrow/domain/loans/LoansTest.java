package com.allegory.sparrow.domain.loans;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LoansTest {

    private LoanOfficer paul;

    @BeforeEach
    public void setUp() {
        paul = new LoanOfficer("Paul", 5);
    }

    @AfterEach
    public void tearDown() {
        paul = null;
    }

    @Test
    public void two_identical_loan_officers_have_the_same_hash_code() {
        final LoanOfficer paulsClone = new LoanOfficer("Paul", 5);
        assertEquals(paul.hashCode(), paulsClone.hashCode());
    }

    @Test
    public void two_identical_loan_officer_are_equal() {
        final LoanOfficer paulsClone = new LoanOfficer("Paul", 5);
        assertEquals(paul, paulsClone);
    }
}
