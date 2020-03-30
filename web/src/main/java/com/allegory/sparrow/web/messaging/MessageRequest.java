package com.allegory.sparrow.web.messaging;

/**
 * A request to send a message.
 */
final class MessageRequest {
    private final String senderName;
    private final String receiverName;
    private final String content;

    /**
     * Create a new request to send a message.
     *
     * @param senderName the name of the participant who is requesting the
     *                   request to send a message.
     * @param receiverName the name of the participant who the requested
     *                     message is to be sent to.
     * @param content the content of the message that is being requested.
     */
    MessageRequest(final String senderName, final String receiverName,
                   final String content) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.content = content;
    }

    String senderName() {
        return senderName;
    }

    String receiverName() {
        return receiverName;
    }

    String content() {
        return content;
    }
}