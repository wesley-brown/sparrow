package com.allegory.sparrow.web.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A message.
 */
final class MessageResponse {
    private final Long id;
    private final String senderName;
    private final String receiverName;
    private final String content;

    /**
     * Create a new message.
     *
     * @param id the unique ID of the message.
     * @param senderName the name of the participant who sent the message.
     * @param receiverName the name of the participant who received the message.
     * @param content the content of the message.
     */
    MessageResponse(final long id, final String senderName,
                    final String receiverName, final String content) {
        this.id = id;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.content = content;
    }

    @JsonProperty
    Long id() {
        return id;
    }

    @JsonProperty
    String senderName() {
        return senderName;
    }

    @JsonProperty
    String receiverName() {
        return receiverName;
    }

    @JsonProperty
    String content() {
        return content;
    }

    @Override
    public int hashCode() {
        // Uses the Effective Java 3 Item 11 algorithm
        return id.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof MessageResponse)) {
            return false;
        }
        final MessageResponse messageResponse = (MessageResponse) other;
        return (messageResponse.id.equals(this.id));
    }

    @Override
    public String toString() {
        return "<id=" + id + "senderName=" + senderName + ", receiverName="
            + receiverName + ", content=" + content + ">";
    }
}
