package com.allegory.sparrow.domain.messaging;

/**
 * A participant in a conversation.
 */
final class Participant {
    private final String name;

    /**
     * Create a new participant.
     *
     * @param name the name of the participant.
     */
    Participant(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = name.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Participant)) {
            return false;
        }
        final Participant participant = (Participant) other;
        return participant.name.equals(this.name);
    }

    @Override
    public String toString() {
        return "<name=" + name + ">";
    }
}
