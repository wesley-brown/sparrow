package com.allegory.sparrow.domain.messaging;

/**
 * A message that has not yet been delivered to its receiver.
 */
public final class UndeliveredMessage {
    private final Conversation conversation;
    private final Participant sender;
    private final String content;

    /**
     * Create a new undelivered message.
     *
     * @param conversation the conversation the message will be a part of.
     * @param sender the participant who will send the message.
     * @param content the content of the message.
     */
    public UndeliveredMessage(final Conversation conversation,
                       final Participant sender, final String content) {
        this.conversation = conversation;
        this.sender = sender;
        this.content = content;
    }

    public Conversation conversation() {
        return conversation;
    }

    public Participant sender() {
        return sender;
    }

    public String content() {
        return content;
    }

    /**
     * Send this message to its receiver.
     *
     * @param receiver the participant who will receive this message.
     * @return The delivered message.
     */
    public DeliveredMessage sendTo(final Participant receiver) {
        final DeliveredMessage deliveredMessage =
            new DeliveredMessage(sender, receiver, content);
        conversation.includeDeliveredMessage(deliveredMessage);
        return deliveredMessage;
    }
}
