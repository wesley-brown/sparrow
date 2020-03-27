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
}
