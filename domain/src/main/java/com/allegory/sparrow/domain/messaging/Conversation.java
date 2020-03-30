package com.allegory.sparrow.domain.messaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A conversation between participants.
 */
public final class Conversation {
    private final List<DeliveredMessage> deliveredMessages;

    /**
     * Create a new conversation.
     */
    public Conversation() {
        deliveredMessages = new ArrayList<>();
    }

    public List<DeliveredMessage> deliveredMessages() {
        return Collections.unmodifiableList(deliveredMessages);
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
