package com.allegory.sparrow.web.messaging.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public final class MessageEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String senderName;
    private String receiverName;
    private String content;

    private MessageEntity() {} // For JPA

    public MessageEntity(final String senderName, final String receiverName,
                         final String content) {
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.content = content;
    }

    public Long id() {
        return id;
    }
}
