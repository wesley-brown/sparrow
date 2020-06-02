package com.allegory.sparrow.app.messaging.sendmessage;

import java.util.UUID;

/**
 * A message that has not yet been delivered to its intended recipient.
 */
public class UndeliveredMessage
{
    private final long conversationId;
    private final UUID senderId;
    private final UUID receiverId;
    private final String content;

    public UndeliveredMessage(
        final long conversationId,
        final UUID senderId,
        final UUID receiverId,
        final String content)
    {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }

    public long conversationId()
    {
        return conversationId;
    }

    public UUID senderId()
    {
        return senderId;
    }

    public UUID receiverId()
    {
        return receiverId;
    }

    public String content()
    {
        return content;
    }
}
