package com.allegory.sparrow.domain.loans;

import com.allegory.sparrow.domain.customers.Customer;
import com.allegory.sparrow.domain.properties.Property;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LoansTest {

    private Customer bob;
    private Property houseBobWants;
    private LoanOfficer paul;
    private LoanApplication bobsLoanApplication;

    @BeforeEach
    public void setUp() {
        bob = new Customer("Bob");
        houseBobWants = new Property("123 Main St");
        paul = new LoanOfficer("Paul", 5);
        bobsLoanApplication = new LoanApplication(bob, houseBobWants, paul);
    }

    @AfterEach
    public void tearDown() {
        bob = null;
        houseBobWants = null;
        paul = null;
        bobsLoanApplication = null;
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

    @Test
    public void identical_loan_applications_have_the_same_hash_codes() {
        final LoanApplication bobsDuplicateLoanApplication =
            new LoanApplication(bob, houseBobWants, paul);
        assertEquals(bobsLoanApplication.hashCode(),
            bobsDuplicateLoanApplication.hashCode());
    }

    @Test
    public void identical_loan_applications_are_equal() {
        final LoanApplication bobsDuplicateLoanApplication =
            new LoanApplication(bob, houseBobWants, paul);
        assertEquals(bobsLoanApplication, bobsDuplicateLoanApplication);
    }
}
