package com.allegory.sparrowserver.loans;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.customers.Customer;
import com.allegory.sparrow.domain.loans.LoanOfficer;
import com.allegory.sparrow.domain.properties.Property;
import java.util.ArrayList;
import java.util.List;
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

    private String paulsName;

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

        paulsName = "Paul";

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

        paulsName = null;

        bobsLoanApplication = null;
        initialLoanApplications = null;
    }

    @Test
    public void two_identical_get_loan_officer_responses_have_the_same_hash_codes() {
        final GetLoanOfficerResponse paul = new GetLoanOfficerResponse("Paul", 5);
        final GetLoanOfficerResponse paulsClone = new GetLoanOfficerResponse("Paul", 5);
        assertEquals(paul.hashCode(), paulsClone.hashCode());
    }

    @Test
    public void two_identical_get_loan_officer_responses_are_equal() {
        final GetLoanOfficerResponse paul = new GetLoanOfficerResponse("Paul", 5);
        final GetLoanOfficerResponse paulsClone = new GetLoanOfficerResponse("Paul", 5);
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
        final List<GetLoanOfficerResponse> receivedLoanOfficers =
            loanOfficersController.loanOfficers();
        final List<GetLoanOfficerResponse> expectedLoanOfficers =
            new ArrayList<>();
        expectedLoanOfficers.add(new GetLoanOfficerResponse("Paul", 5));
        expectedLoanOfficers.add(new GetLoanOfficerResponse("Alice", 5));

        assertThat(receivedLoanOfficers).containsExactlyInAnyOrderElementsOf(
                expectedLoanOfficers);
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
        final List<LoanApplicationResponse> expectedLoanApplications =
            new ArrayList<>();
        expectedLoanApplications.add(new LoanApplicationResponse(
            "Bob", "123 Main St", "Paul"
        ));
        expectedLoanApplications.add(new LoanApplicationResponse(
            "Jimmy", "789 Oak Ave", "Paul"
        ));
        final List<LoanApplicationResponse> receivedLoanApplications =
            loanApplicationsController.loanApplications();
        assertThat(receivedLoanApplications)
            .containsExactlyInAnyOrderElementsOf(expectedLoanApplications);
    }

    @Test
    public void posting_a_valid_loan_application_request_returns_an_equivalent_loan_application() {
        final PostLoanApplicationRequest alicesLoanApplicationRequest =
                new PostLoanApplicationRequest(
                        alicesName, addressOfApartmentAliceWants);
        final LoanApplicationResponse receivedLoanApplication =
                loanApplicationsController.postLoanApplicationRequest(alicesLoanApplicationRequest);
        final Customer alice = new Customer(alicesName);
        final Property apartmentAliceWants =
                new Property(addressOfApartmentAliceWants);
        final LoanApplicationResponse alicesExpectedLoanApplication = new
                LoanApplicationResponse(
                alicesName,
                addressOfApartmentAliceWants,
                paulsName
            );
        assertEquals(alicesExpectedLoanApplication, receivedLoanApplication);
    }

    @Test
    public void two_identical_loan_application_post_responses_should_have_the_same_hash_codes() {
        final LoanApplicationResponse alicesLoanApplication = new
                LoanApplicationResponse(
                alicesName,
                addressOfApartmentAliceWants,
                paulsName
            );
        final LoanApplicationResponse alicesDuplicateLoanApplication = new
                LoanApplicationResponse(
                alicesName,
                addressOfApartmentAliceWants,
                paulsName
            );
        assertEquals(
            alicesLoanApplication.hashCode(),
            alicesDuplicateLoanApplication.hashCode()
        );
    }

    @Test
    public void two_identical_loan_application_post_responses_are_equal() {
        final LoanApplicationResponse alicesLoanApplication = new
                LoanApplicationResponse(
                alicesName,
                addressOfApartmentAliceWants,
                paulsName
            );
        final LoanApplicationResponse alicesDuplicateLoanApplication = new
                LoanApplicationResponse(
                alicesName,
                addressOfApartmentAliceWants,
                paulsName
            );
        assertEquals(alicesLoanApplication, alicesDuplicateLoanApplication);
    }
}
