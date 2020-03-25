package com.allegory.sparrowserver.properties;

/**
 * Data for a response to a GET request for a property.
 */
public final class GetPropertyResponse {
    private final String propertyAddress;

    /**
     * Create a new GetPropertyResponse.
     *
     * @param propertyAddress the address of the property that was requested.
     */
    public GetPropertyResponse(final String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        return propertyAddress.hashCode();
    }
}
