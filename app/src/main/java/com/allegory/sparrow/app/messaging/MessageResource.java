package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * A web resource for a message.
 */
public final class MessageResource
{
    private final UUID messageId;
    private final ParticipantResource sender;
    private final String messageContent;

    /**
     * Create a new message resource from a given message.
     *
     * @param message the message to create the new conversation resource from.
     * @return the newly created message resource.
     */
    public static MessageResource fromMessage(final Message message)
    {
        final ParticipantResource sender =
            ParticipantResource.fromParticipant(message.sender());
        return new MessageResource(message.id(), sender, message.content());
    }

    private MessageResource(
        final UUID messageId,
        final ParticipantResource sender,
        final String messageContent)
    {
        this.messageId = messageId;
        this.sender = sender;
        this.messageContent = messageContent;
    }

    @JsonProperty
    public UUID messageId()
    {
        return messageId;
    }

    @JsonProperty
    public UUID senderId()
    {
        return sender.id();
    }

    @JsonProperty
    public String content()
    {
        return messageContent;
    }
}
