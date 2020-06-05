package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * A web resource for a message.
 */
public final class MessageResource
{
    private final Message message;

    /**
     * Create a new message resource from a given message.
     *
     * @param message the message to create the new conversation resource from.
     * @return the newly created message resource.
     */
    public static MessageResource fromMessage(final Message message)
    {
        return new MessageResource(message);
    }

    private MessageResource(final Message message)
    {
        this.message = message;
    }

    @JsonProperty
    public UUID id()
    {
        return message.id();
    }

    public ParticipantResource sender()
    {
        return ParticipantResource.fromParticipant(message.sender());
    }

    @JsonProperty
    public String content()
    {
        return message.content();
    }

    @Override
    public int hashCode()
    {
        // Uses the Effective Java 3 Item 11 algorithm
        final int result = message.hashCode();
        return result;
    }
}
