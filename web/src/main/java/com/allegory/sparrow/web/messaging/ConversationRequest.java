package com.allegory.sparrow.web.messaging;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    ConversationRequest(@JsonProperty("participantNames") final List<String> participantNames) {
        this.participantNames = participantNames;
    }

    List<String> participantNames() {
        return participantNames;
    }
}
