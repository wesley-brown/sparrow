package com.allegory.sparrowserver.loans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POST response data for a REST endpoint used to apply for a loan.
 */
public final class LoanApplicationPostResponse {
    private final String applicantName;
    private final String propertyAddress;
    private final String loanOfficerName;

    /**
     * Create a new LoanApplicationPostResponse.
     *
     * @param applicantName the name of the applicant the loan is for.
     * @param propertyAddress the address of the property the loan is for.
     * @param loanOfficerName the name of the loan officer the loan was applied
     *                        through.
     */
    public LoanApplicationPostResponse(
            final String applicantName,
            final String propertyAddress,
            final String loanOfficerName) {
        this.applicantName = applicantName;
        this.propertyAddress = propertyAddress;
        this.loanOfficerName = loanOfficerName;
    }

    @JsonProperty
    public String applicantName() {
        return applicantName;
    }

    @JsonProperty
    public String propertyAddress() {
        return propertyAddress;
    }

    @JsonProperty
    public String loanOfficerName() {
        return loanOfficerName;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = applicantName.hashCode();
        result = 31 * result * propertyAddress.hashCode();
        result = 31 * result * loanOfficerName.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof LoanApplicationPostResponse)) {
            return false;
        }

        final LoanApplicationPostResponse otherLoanAppResponse =
            (LoanApplicationPostResponse) other;
        return (otherLoanAppResponse.applicantName.equals(this.applicantName))
            && (otherLoanAppResponse.propertyAddress.equals(this.propertyAddress))
            && (otherLoanAppResponse.loanOfficerName.equals(this.loanOfficerName));
    }

    @Override
    public String toString() {
        return "<applicantName=" + applicantName + ", propertyAddress="
                + propertyAddress + ", loanOfficerName=" + loanOfficerName
                + ">";
    }
}
