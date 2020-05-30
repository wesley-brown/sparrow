package com.allegory.sparrow.app.messaging.persistence;

import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public final class PersistedMessage
{
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private PersistedParticipant sender;
    @OneToOne
    private PersistedParticipant receiver;
    private Long conversationId;
    private String content;

    private PersistedMessage() {} // For JPA

    public static PersistedMessage fromMessage(final Message message)
    {
        return new PersistedMessage();
    }

    public PersistedMessage(
        final PersistedParticipant sender,
        final PersistedParticipant receiver,
        final String content)
    {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Long getId()
    {
        return id;
    }

    public PersistedParticipant getSender()
    {
        return sender;
    }

    public PersistedParticipant getReceiver()
    {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public Message message()
    {
        final Participant sender = getSender().participant();
        final Participant receiver = getReceiver().participant();
        return new Message(sender, receiver, getContent());
    }
}
