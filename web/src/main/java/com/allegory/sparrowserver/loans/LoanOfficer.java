package com.allegory.sparrowserver.loans;

import com.fasterxml.jackson.annotation.JsonProperty;

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

        if (!(other instanceof LoanOfficer)) {
            return false;
        }

        final LoanOfficer loanOfficer = (LoanOfficer) other;
        return (loanOfficer.name.equals(this.name))
                && (loanOfficer.rating == this.rating);
    }

    @Override
    public String toString() {
        return "<name=" + name + ", rating=" + rating + ">";
    }
}
