package com.allegory.sparrow.app.messaging.sendmessage;

/**
 * A message that has not yet been delivered to its intended recipient.
 */
public class UndeliveredMessage
{
    private final long conversationId;
    private final String senderName;
    private final String receiverName;
    private final String content;

    public UndeliveredMessage(
        final long conversationId,
        final String senderName,
        final String receiverName,
        final String content)
    {
        this.conversationId = conversationId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.content = content;
    }

    public long conversationId()
    {
        return conversationId;
    }

    public String senderName()
    {
        return senderName;
    }

    public String receiverName()
    {
        return receiverName;
    }

    public String content()
    {
        return content;
    }
}
