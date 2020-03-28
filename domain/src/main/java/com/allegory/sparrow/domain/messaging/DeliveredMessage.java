package com.allegory.sparrow.domain.messaging;

/**
 * A message that has been delivered to its receiver.
 */
final class DeliveredMessage {
    private final Participant sender;
    private final Participant receiver;
    private final String content;

    /**
     * Create a new delivered message.
     *
     * @param sender the participant who sent the message.
     * @param receiver the participant who received the message.
     * @param content the content of the message.
     */
    DeliveredMessage(final Participant sender, final Participant receiver,
                     final String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = sender.hashCode();
        result = 31 * result * receiver.hashCode();
        result = 31 * result * content.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof DeliveredMessage)) {
            return false;
        }
        final DeliveredMessage deliveredMessage = (DeliveredMessage) other;
        return (deliveredMessage.sender.equals(this.sender))
                && (deliveredMessage.receiver.equals(this.receiver))
                && (deliveredMessage.content.equals(this.content));
    }

    @Override
    public String toString() {
        return "<sender=" + sender + ", receiver=" + receiver + ", content="
                + content + ">";
    }
}
