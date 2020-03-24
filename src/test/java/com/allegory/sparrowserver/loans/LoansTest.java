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

    private String alicesName;
    private String addressOfApartmentAliceWants;

    private List<LoanApplication> initialLoanApplications;
    private LoanApplicationsController loanApplicationsController;

    @BeforeEach
    public void setUp() {
        bob = new Customer("Bob");
        propertyBobWants = new Property("123 Main St");
        paul = new LoanOfficer("Paul", 5);
        bobsLoanApplication = new LoanApplication(
                bob, propertyBobWants, paul);

        alicesName = "Alice";
        addressOfApartmentAliceWants = "456 Second St";

        initialLoanApplications = new ArrayList<>();
        initialLoanApplications.add(bobsLoanApplication);
        initialLoanApplications.add(new LoanApplication(
                new Customer("Jimmy"),
                new Property("789 Oak Ave"),
                paul
        ));
        loanApplicationsController =
                new LoanApplicationsController(initialLoanApplications);
    }

    @AfterEach
    public void tearDown() {
        bob = null;
        propertyBobWants = null;
        paul = null;

        alicesName = null;
        addressOfApartmentAliceWants = null;

        bobsLoanApplication = null;
        initialLoanApplications = null;
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

    @Test
    public void getting_all_loan_applications_returns_all_loan_applications() {
        final List<LoanApplication> allLoanApplications =
                loanApplicationsController.loanApplications();
        assertThat(allLoanApplications).containsExactlyInAnyOrderElementsOf(
                initialLoanApplications);
    }

    @Test
    public void posting_a_valid_loan_application_request_returns_an_equivalent_loan_application() {
        final LoanApplicationPostRequest alicesLoanApplicationRequest =
                new LoanApplicationPostRequest(
                        alicesName, addressOfApartmentAliceWants);
        final LoanApplication receivedLoanApplication =
                loanApplicationsController.postLoanApplicationRequest(alicesLoanApplicationRequest);
        final Customer alice = new Customer(alicesName);
        final Property apartmentAliceWants =
                new Property(addressOfApartmentAliceWants);
        final LoanApplication alicesLoanApplication = new LoanApplication(
                alice, apartmentAliceWants, paul);
        assertEquals(alicesLoanApplication, receivedLoanApplication);
    }

    @Test
    public void two_identical_loan_application_post_responses_should_have_the_same_hash_codes() {
        final String paulsName = "Paul";
        final LoanApplicationPostResponse alicesLoanApplication = new
            LoanApplicationPostResponse(
                alicesName,
                addressOfApartmentAliceWants,
                paulsName
            );
        final LoanApplicationPostResponse alicesDuplicateLoanApplication = new
            LoanApplicationPostResponse(
                alicesName,
                addressOfApartmentAliceWants,
                paulsName
            );
        assertEquals(
            alicesLoanApplication.hashCode(),
            alicesDuplicateLoanApplication.hashCode()
        );
    }
}
