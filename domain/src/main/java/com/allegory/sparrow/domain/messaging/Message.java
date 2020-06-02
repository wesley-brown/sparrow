package com.allegory.sparrow.domain.messaging;

import java.util.UUID;

/**
 * A message.
 */
public final class Message
{
    private final UUID id;
    private final Participant sender;
    private final Participant receiver;
    private final String content;

    /**
     * Create a new message.
     *
     * @param id the unique identifier of the message.
     * @param sender the participant who sent the message.
     * @param receiver the participant who received the message.
     * @param content the content of the message.
     */
    public static Message withIdFromSenderToReceiverWithContent(
        final UUID id,
        final Participant sender,
        final Participant receiver,
        final String content)
    {
        return new Message(id, sender, receiver, content);
    }

    private Message(
        final UUID id,
        final Participant sender,
        final Participant receiver,
        final String content)
    {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public UUID id()
    {
        return id;
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
        return id.hashCode();
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
        return otherMessage.id == this.id;
    }

    @Override
    public String toString()
    {
        return "<id=" + id() + ", sender=" + sender() + ", receiver="
            + receiver() + ", content=" + content() + ">";
    }
}
