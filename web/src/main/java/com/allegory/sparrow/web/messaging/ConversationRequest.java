package com.allegory.sparrow.web.messaging;

import java.util.List;

/**
 * A request to create a new conversation.
 */
final class ConversationRequest {
    private final List<String> participantNames;

    /**
     * Create a request to create a new conversation.
     *
     * @param participantNames the names of the participants in the
     *                         new conversation to create.
     */
    ConversationRequest(final List<String> participantNames) {
        this.participantNames = participantNames;
    }

    List<String> participantNames() {
        return participantNames;
    }
}
