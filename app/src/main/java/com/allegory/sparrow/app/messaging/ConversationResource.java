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
    private final UUID conversationId;
    private final List<ParticipantResource> participants;
    private final List<MessageResource> messages;

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
        final List<ParticipantResource> participants = new ArrayList<>();
        for (final Participant participant : conversation.participants())
        {
            participants.add(ParticipantResource.fromParticipant(participant));
        }
        final List<MessageResource> messages = new ArrayList<>();
        for (final Message message : conversation.messages())
        {
            messages.add(MessageResource.fromMessage(message));
        }
        return new ConversationResource(
            conversation.id(),
            participants,
            messages);
    }

    private ConversationResource(
        final UUID conversationId,
        final List<ParticipantResource> participants,
        final List<MessageResource> messages)
    {
        this.conversationId = conversationId;
        this.participants = participants;
        this.messages = messages;
    }

    @JsonProperty
    public UUID conversationId()
    {
        return conversationId;
    }

    @JsonProperty
    public List<ParticipantResource> participants()
    {
        return new ArrayList<>(participants);
    }

    @JsonProperty
    public List<MessageResource> messages()
    {
        return new ArrayList<>(messages);
    }

    @Override
    public int hashCode()
    {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = conversationId.hashCode();
        result = 31 * result + participants.hashCode();
        result = 31 * result + messages.hashCode();
        return result;
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
        return otherResource.conversationId.equals(this.conversationId)
            && otherResource.participants.equals(this.participants)
            && otherResource.messages.equals(this.messages);
    }

    @Override
    public String toString()
    {
        return "<ConversationResponse:" + " id=" + conversationId
            + ", participants=" + participants + ", messages=" + messages + ">";
    }
}
