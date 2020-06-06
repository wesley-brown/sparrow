package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A web resource for a conversation.
 */
public final class ConversationResource
{
    private final Conversation conversation;

    /**
     * Create a new conversation resource from a given conversation.
     *
     * @param conversation the conversation to create the new conversation
     *                     resource from.
     * @return the newly created conversation resource.
     */
    public static ConversationResource fromConversation(
        final Conversation conversation)
    {
        return new ConversationResource(conversation);
    }

    private ConversationResource(final Conversation conversation)
    {
        this.conversation = conversation;
    }

    @JsonProperty
    public UUID id()
    {
        return conversation.id();
    }

    @JsonProperty
    public List<ParticipantResource> participants()
    {
        final List<ParticipantResource> participants = new ArrayList<>();
        for (final Participant participant : conversation.participants())
        {
            final ParticipantResource participantResource =
                ParticipantResource.fromParticipant(participant);
            participants.add(participantResource);
        }
        return participants;
    }

    @JsonProperty
    public List<MessageResource> messages()
    {
        final List<MessageResource> messages = new ArrayList<>();
        for (final Message message : conversation.messages())
        {
            final MessageResource messageResource =
                MessageResource.fromMessage(message);
            messages.add(messageResource);
        }
        return messages;
    }

    @Override
    public int hashCode()
    {
        return conversation.hashCode();
    }

    @Override
    public boolean equals(final Object other)
    {
        if (other == this)
        {
            return true;
        }
        if (!(other instanceof ConversationResource))
        {
            return false;
        }
        final ConversationResource otherResource = (ConversationResource) other;
        return otherResource.conversation.equals(this.conversation);
    }

    @Override
    public String toString()
    {
        return "<ConversationResponse:" + " id=" + id() + ", participants="
            + participants() + ", messages=" + messages() + ">";
    }
}
