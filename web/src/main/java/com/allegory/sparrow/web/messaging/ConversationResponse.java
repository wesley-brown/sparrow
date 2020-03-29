package com.allegory.sparrow.web.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * A response to a request for a conversation.
 */
final class ConversationResponse {
    private final Long id;
    private final List<String> participantNames;
    private final List<Message> messages;

    /**
     * Create a new conversation response.
     *
     * @param id the unique ID of the requested conversation.
     * @param participantNames the names of the participants in the
     *                         requested conversation.
     * @param messages the messages in the requested conversation.
     */
    ConversationResponse(final long id, final List<String> participantNames,
                         final List<Message> messages) {
        this.id = id;
        this.participantNames = participantNames;
        this.messages = messages;
    }

    @JsonProperty
    Long id() {
        return id;
    }

    @JsonProperty
    List<String> participantNames() {
        return participantNames;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        return id.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ConversationResponse)) {
            return false;
        }
        final ConversationResponse conversation = (ConversationResponse) other;
        return (conversation.id.equals(this.id));
    }

    @Override
    public String toString() {
        return "<id=" + id + ", participantNames=" + participantNames
            + ", messages=" + messages + ">";
    }
}
