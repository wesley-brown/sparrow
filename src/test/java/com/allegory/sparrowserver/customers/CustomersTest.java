package com.allegory.sparrowserver.customers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrowserver.loans.LoanApplication;
import com.allegory.sparrowserver.loans.LoanOfficer;
import com.allegory.sparrowserver.properties.Property;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class CustomersTest {
    private Customer bob;

    @BeforeEach
    private void setUp() {
        bob = new Customer("Bob");
    }

    @AfterEach
    private void tearDown() {
        bob = null;
    }

    @Test
    public void two_identical_customers_have_the_same_hash_codes() {
        final Customer bobsClone = new Customer("Bob");
        assertEquals(bob.hashCode(), bobsClone.hashCode());
    }

    @Test
    public void two_identical_customers_should_be_equal() {
        final Customer bobsClone = new Customer("Bob");
        assertEquals(bob, bobsClone);
    }

    @Test
    public void a_customer_can_apply_for_a_loan() {
        final LoanOfficer paul = new LoanOfficer("Paul", 5);
        final Property houseBobWants = new Property("123 Main St");
        final LoanApplication bobsActualLoanApplication =
                bob.applyForLoan(houseBobWants, paul);
        final LoanApplication bobsExpectedLoanApplication =
                new LoanApplication(bob, houseBobWants, paul);
        assertEquals(bobsExpectedLoanApplication, bobsActualLoanApplication);
    }
}
