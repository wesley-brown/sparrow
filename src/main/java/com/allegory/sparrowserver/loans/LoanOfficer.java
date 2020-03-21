package com.allegory.sparrowserver.loans;

/**
 * Assists people applying for loans.
 */
public final class LoanOfficer {
    private final String name;
    private final int rating;

    /**
     * Create a new LoanOfficer.
     *
     * @param name the name of the new LoanOfficer.
     * @param rating the rating of the new LoanOfficer.
     */
    public LoanOfficer(final String name, final int rating) {
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
