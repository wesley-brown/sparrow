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

    @Test
    public void getting_all_loan_officers_returns_all_loan_officers() {
        final List<LoanOfficer> initialLoanOfficers = new ArrayList<>();
        initialLoanOfficers.add(loanOfficerOne);
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
        final Customer bob = new Customer("Bob");
        final Property house = new Property("123 Main St");
        final LoanOfficer paul = new LoanOfficer("Paul", 5);
        final LoanApplication loanApplicationOne = new LoanApplication(
                bob, house, paul);
        final LoanApplication loanApplicationTwo = new LoanApplication(
                bob, house, paul);
        assertEquals(loanApplicationOne.hashCode(),
                loanApplicationTwo.hashCode());
    }
}
