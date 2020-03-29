package com.allegory.sparrow.web.messaging;

/**
 * A message.
 */
final class Message {
    private String senderName;
    private String receiverName;
    private String content;

    /**
     * Create a new message.
     *
     * @param senderName the name of the participant who sent the message.
     * @param receiverName the name of the participant who received the message.
     * @param content the content of the message.
     */
    Message(final String senderName, final String receiverName,
            final String content) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.content = content;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = senderName.hashCode();
        result = 31 * result * receiverName.hashCode();
        result = 31 * result * content.hashCode();
        return result;
    }
}
