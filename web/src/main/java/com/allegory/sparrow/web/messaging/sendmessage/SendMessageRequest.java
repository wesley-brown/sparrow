package com.allegory.sparrow.web.messaging.sendmessage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * A request to send a message.
 */
final class SendMessageRequest
{
    private final UUID senderId;
    private final String content;

    /**
     * Create a new request to send a message.
     *
     * @param senderId the ID of the participant who is making the send message
     *                 request.
     * @param content the content of the message that is being requested.
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    SendMessageRequest(
        @JsonProperty("senderId") final UUID senderId,
        @JsonProperty("content") final String content)
    {
        this.senderId = senderId;
        this.content = content;
    }

    UUID senderId()
    {
        return senderId;
    }

    String content()
    {
        return content;
    }
}
