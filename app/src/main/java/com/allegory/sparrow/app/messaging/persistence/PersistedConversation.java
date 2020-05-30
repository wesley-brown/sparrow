package com.allegory.sparrow.app.messaging.persistence;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public final class PersistedConversation
{
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<PersistedParticipant> participants;

    @OneToMany
    private List<PersistedMessage> messages;

    private PersistedConversation() {} // For JPA

    public PersistedConversation(
        final List<PersistedParticipant> participants,
        final List<PersistedMessage> messages)
    {
        this.participants = participants;
        this.messages = messages;
    }

    public Long getId()
    {
        return id;
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
            final String name = persistedParticipant.getName();
            final Participant participant = new Participant(name);
            participants.add(participant);
        }

        final List<Message> messages = new ArrayList<>();
        for (final PersistedMessage persistedMessage : getMessages())
        {
            final Message message = persistedMessage.message();
            messages.add(message);
        }
        return Conversation.betweenParticipantsWithMessages(
            participants,
            messages);
    }
}
