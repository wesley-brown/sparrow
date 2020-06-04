package com.allegory.sparrow.app.messaging.sendmessage;

import java.util.UUID;

/**
 * A message that has not yet been delivered to its intended recipient.
 */
public class UndeliveredMessage
{
    private final UUID conversationId;
    private final UUID senderId;
    private final String content;

    public UndeliveredMessage(
        final UUID conversationId,
        final UUID senderId,
        final String content)
    {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.content = content;
    }

    public UUID conversationId()
    {
        return conversationId;
    }

    public UUID senderId()
    {
        return senderId;
    }

    public String content()
    {
        return content;
    }
}
