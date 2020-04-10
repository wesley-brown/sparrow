package com.allegory.sparrow.app.messaging.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public final class MessageEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private ParticipantEntity sender;
    @OneToOne
    private ParticipantEntity receiver;
    private Long conversationId;
    private String content;

    private MessageEntity() {} // For JPA

    public MessageEntity(final ParticipantEntity sender,
                         final ParticipantEntity receiver,
                         final String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public ParticipantEntity getSender() {
        return sender;
    }

    public ParticipantEntity getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }
}
