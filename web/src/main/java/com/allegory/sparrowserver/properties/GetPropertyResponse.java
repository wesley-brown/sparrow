package com.allegory.sparrowserver.properties;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty
    public String propertyAddress() {
        return propertyAddress;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        return propertyAddress.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof GetPropertyResponse)) {
            return false;
        }

        final GetPropertyResponse property = (GetPropertyResponse) other;
        return property.propertyAddress.equals(this.propertyAddress);
    }

    @Override
    public String toString() {
        return "<propertyAddress=" + propertyAddress + ">";
    }
}
