package com.allegory.sparrowserver.properties;

/**
 * A real estate property.
 */
public final class Property {
    private final String address;

    /**
     * Create a new Property with the given address.
     *
     * @param address the address the Property is located at
     */
    public Property(final String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = address.hashCode();
        return result;
    }
}
