package com.allegory.sparrowserver.loans;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response data for a GET request to a REST endpoint that returns loan
 * officers.
 */
public final class GetLoanOfficerResponse {
    private final String name;
    private final int rating;

    /**
     * Create a new GetLoanOfficerResponse.
     *
     * @param name the name of the loan officer.
     * @param rating the rating of the loan officer.
     */
    public GetLoanOfficerResponse(final String name, final int rating) {
        this.name = name;
        this.rating = rating;
    }

    @JsonProperty
    public String name() {
        return name;
    }

    @JsonProperty
    public int rating() {
        return rating;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = name.hashCode();
        result = 31 * result * Integer.hashCode(rating);
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof GetLoanOfficerResponse)) {
            return false;
        }
        final GetLoanOfficerResponse loanOfficer =
            (GetLoanOfficerResponse) other;
        return (loanOfficer.name.equals(this.name))
            && (loanOfficer.rating == this.rating);
    }

    @Override
    public String toString() {
        return "<name=" + name + ", rating=" + rating + ">";
    }
}
