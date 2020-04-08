package com.allegory.sparrow.domain.messaging;

import java.util.ArrayList;
import java.util.List;

/**
 * A conversation between participants.
 */
public final class Conversation {
    private final List<Participant> participants;
    private final List<Message> messages;

    /**
     * Create a new conversation.
     *
     * @param participants the participants of the new conversation.
     */
    public Conversation(final List<Participant> participants) {
        this.participants = participants;
        messages = new ArrayList<>();
    }

    public List<Message> messages() {
        return messages;
    }

    /**
     * Include a message in this conversation.
     *
     * @param message the message to include.
     * @return the included message.
     */
    public Message includeMessage(final Message message) {
        messages.add(message);
        return message;
    }
}
