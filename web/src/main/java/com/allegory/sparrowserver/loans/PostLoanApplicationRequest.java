package com.allegory.sparrowserver.loans;

/**
 * POST request data for a REST endpoint used to apply for a loan.
 */
final class PostLoanApplicationRequest {
    private final String buyer;
    private final String propertyAddress;

    PostLoanApplicationRequest(final String buyer,
                               final String propertyAddress) {
        this.buyer = buyer;
        this.propertyAddress = propertyAddress;
    }

    String buyer() {
        return buyer;
    }

    String propertyAddress() {
        return propertyAddress;
    }
}
