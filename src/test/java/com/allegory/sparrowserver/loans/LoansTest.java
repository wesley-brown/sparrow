package com.allegory.sparrowserver.loans;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.allegory.sparrowserver.customers.Customer;
import com.allegory.sparrowserver.properties.Property;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class LoansTest {

    private Customer bob;
    private Property propertyBobWants;
    private LoanOfficer paul;
    private LoanApplication bobsLoanApplication;

    @BeforeEach
    public void setUp() {
        bob = new Customer("Bob");
        propertyBobWants = new Property("123 Main St");
        paul = new LoanOfficer("Paul", 5);
        bobsLoanApplication = new LoanApplication(
                bob, propertyBobWants, paul);
    }

    @AfterEach
    public void tearDown() {
        bob = null;
        propertyBobWants = null;
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
    public void getting_all_loan_officers_returns_all_loan_officers() {
        final List<LoanOfficer> initialLoanOfficers = new ArrayList<>();
        initialLoanOfficers.add(paul);
        initialLoanOfficers.add(new LoanOfficer("Alice", 5));
        final LoanOfficersService loanOfficersService =
                new LoanOfficersService(initialLoanOfficers);
        final LoanOfficersController loanOfficersController =
                new LoanOfficersController(loanOfficersService);
        final List<LoanOfficer> receivedLoanOfficers =
                loanOfficersController.loanOfficers();
        assertThat(receivedLoanOfficers).containsExactlyInAnyOrderElementsOf(
                initialLoanOfficers);
    }

    @Test
    public void two_identical_loan_applications_have_the_same_hash_codes() {
        final LoanApplication bobsDuplicateLoanApplication =
                new LoanApplication(bob, propertyBobWants, paul);
        assertEquals(bobsLoanApplication.hashCode(),
                bobsDuplicateLoanApplication.hashCode());
    }

    @Test
    public void two_identical_loan_applications_should_be_equal() {
        final LoanApplication bobsDuplicateLoanApplication =
                new LoanApplication(bob, propertyBobWants, paul);
        assertEquals(bobsLoanApplication, bobsDuplicateLoanApplication);
    }
}
