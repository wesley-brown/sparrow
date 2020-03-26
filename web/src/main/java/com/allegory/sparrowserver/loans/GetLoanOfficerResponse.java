package com.allegory.sparrowserver.loans;

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

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = name.hashCode();
        result = 31 * result * Integer.hashCode(rating);
        return result;
    }
}
