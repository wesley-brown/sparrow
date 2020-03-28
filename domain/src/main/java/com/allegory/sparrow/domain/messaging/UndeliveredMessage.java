package com.allegory.sparrow.domain.messaging;

/**
 * A message that has not yet been delivered to its receiver.
 */
final class UndeliveredMessage {
    private final Participant sender;
    private final String content;

    /**
     * Create a new undelivered message.
     *
     * @param conversation the conversation the message will be a part of.
     * @param sender the participant who will send the message.
     * @param content the content of the message.
     */
    UndeliveredMessage(final Conversation conversation,
                       final Participant sender, final String content) {
        this.sender = sender;
        this.content = content;
    }

    /**
     * Send this message to its receiver.
     *
     * @param receiver the participant who will receive this message.
     * @return The delivered message.
     */
    DeliveredMessage sendTo(final Participant receiver) {
        return new DeliveredMessage(sender, receiver, content);
    }
}
