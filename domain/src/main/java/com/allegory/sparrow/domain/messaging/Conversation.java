package com.allegory.sparrow.domain.messaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A conversation between participants.
 */
final class Conversation {
    private final List<DeliveredMessage> deliveredMessages;

    /**
     * Create a new conversation.
     */
    Conversation() {
        deliveredMessages = new ArrayList<>();
    }

    List<DeliveredMessage> deliveredMessages() {
        return Collections.unmodifiableList(deliveredMessages);
    }

    /**
     * Include a new delivered message in this conversation.
     *
     * @param deliveredMessage the new delivered message to include.
     */
    void includeDeliveredMessage(final DeliveredMessage deliveredMessage) {
        deliveredMessages.add(deliveredMessage);
    }
}
