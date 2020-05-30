package com.allegory.sparrow.domain.messaging;

import java.util.UUID;

/**
 * A message.
 */
public final class Message
{
    private final UUID uuid;
    private final Participant sender;
    private final Participant receiver;
    private final String content;

    /**
     * Create a new message.
     *
     * @param sender the participant who sent the message.
     * @param receiver the participant who received the message.
     * @param content the content of the message.
     */
    public Message(
        final Participant sender,
        final Participant receiver,
        final String content)
    {
        this.uuid = UUID.randomUUID();
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public UUID uuid()
    {
        return uuid;
    }

    public Participant sender()
    {
        return sender;
    }

    public Participant receiver()
    {
        return receiver;
    }

    public String content()
    {
        return content;
    }

    @Override
    public int hashCode()
    {
        // Uses the Effective Java 3 Item 11 algorithm
        return uuid.hashCode();
    }

    @Override
    public boolean equals(final Object other)
    {
        if (other == this)
        {
            return true;
        }
        if (!(other instanceof Message))
        {
            return false;
        }
        final Message otherMessage = (Message) other;
        return otherMessage.uuid == this.uuid;
    }

    @Override
    public String toString()
    {
        return "<uuid=" + uuid + ", sender=" + sender + ", receiver="
            + receiver + ", content=" + content + ">";
    }
}
