package com.allegory.sparrowserver.properties;

/**
 * A real estate property.
 */
public final class Property {
    private final String address;

    /**
     * Create a new Property with the given address.
     *
     * @param address the address the Property is located at.
     */
    public Property(final String address) {
        this.address = address;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Property)) {
            return false;
        }

        final Property property = (Property) other;
        return property.address.equals(this.address);
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "<address=" + address + ">";
    }
}
