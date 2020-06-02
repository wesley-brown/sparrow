package com.allegory.sparrow.persistence.messaging.sendmessage;

import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.UUID;
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
    private UUID messageId;

    @OneToOne
    private PersistedParticipant sender;
    @OneToOne
    private PersistedParticipant receiver;
    private Long conversationId;
    private String content;

    private PersistedMessage() {} // For JPA

    public PersistedMessage(
        final UUID messageId,
        final PersistedParticipant sender,
        final PersistedParticipant receiver,
        final String content)
    {
        this.messageId = messageId;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Long getId()
    {
        return id;
    }

    public UUID getMessageId()
    {
        return messageId;
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
        return Message.withIdFromSenderToReceiverWithContent(
            getMessageId(),
            sender,
            receiver,
            getContent()
        );
    }
}
