package com.allegory.sparrow.web.messaging;

import java.util.List;

/**
 * A response to a request for a conversation.
 */
final class ConversationResponse {
    private final long id;
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

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = Long.hashCode(id);
        result = 31 * result * participantNames.hashCode();
        result = 31 * result * messages.hashCode();
        return result;
    }
}
