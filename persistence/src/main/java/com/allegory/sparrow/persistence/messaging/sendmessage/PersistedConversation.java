package com.allegory.sparrow.persistence.messaging.sendmessage;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public final class PersistedConversation
{
    @Id
    @GeneratedValue
    private Long id;
    private UUID conversationId;

    @OneToMany
    private List<PersistedParticipant> participants;

    @OneToMany
    private List<PersistedMessage> messages;

    private PersistedConversation() {} // For JPA

    public PersistedConversation(
        final UUID conversationId,
        final List<PersistedParticipant> participants,
        final List<PersistedMessage> messages)
    {
        this.conversationId = conversationId;
        this.participants = participants;
        this.messages = messages;
    }

    public Long getId()
    {
        return id;
    }

    public UUID getConversationId()
    {
        return conversationId;
    }

    public List<PersistedParticipant> getParticipants()
    {
        return participants;
    }

    public List<PersistedMessage> getMessages()
    {
        return messages;
    }

    public Conversation conversation()
    {
        final List<Participant> participants = new ArrayList<>();
        for (final PersistedParticipant persistedParticipant : getParticipants())
        {
            final Participant participant = persistedParticipant.participant();
            participants.add(participant);
        }

        final List<Message> messages = new ArrayList<>();
        for (final PersistedMessage persistedMessage : getMessages())
        {
            final Message message = persistedMessage.message();
            messages.add(message);
        }
        return Conversation.withIdBetweenParticipantsWithMessages(
            getConversationId(),
            participants,
            messages);
    }
}
