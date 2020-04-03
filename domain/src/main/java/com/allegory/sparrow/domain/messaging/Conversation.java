package com.allegory.sparrow.domain.messaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A conversation between participants.
 */
public final class Conversation {
    private final List<DeliveredMessage> deliveredMessages;
    private final List<Participant> participants;
    private final List<Message> messages;

    /**
     * Create a new conversation.
     */
    public Conversation() {
        deliveredMessages = new ArrayList<>();
        participants = null;
        messages = new ArrayList<>();
    }

    public Conversation(final List<Participant> participants) {
        deliveredMessages = null;
        this.participants = participants;
        messages = new ArrayList<>();
    }

    public List<DeliveredMessage> deliveredMessages() {
        return Collections.unmodifiableList(deliveredMessages);
    }

    public List<Message> messages() {
        return messages;
    }

    public Message includeMessage(final Message message) {
        messages.add(message);
        return message;
    }

    /**
     * Include a new delivered message in this conversation.
     *
     * @param deliveredMessage the new delivered message to include.
     */
    public void includeDeliveredMessage(final DeliveredMessage deliveredMessage) {
        deliveredMessages.add(deliveredMessage);
    }
}
