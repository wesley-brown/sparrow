package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;

/**
 * A message delivery.
 */
public final class MessageDelivery {

    /**
     * Create a new message delivery for a conversation.
     *
     * @param conversation the conversation in which the new message delivery
     *                     will deliver messages.
     * @return the new message delivery.
     */
    public static MessageDelivery forConversation(
        final Conversation conversation) {
        return new MessageDelivery(conversation);
    }

    private MessageDelivery(final Conversation conversation) {
    }

    /**
     * Deliver a message.
     *
     * @param message the message to deliver.
     * @return the delivered message.
     */
    public Message deliverMessage(final Message message) {
        return message;
    }
}
