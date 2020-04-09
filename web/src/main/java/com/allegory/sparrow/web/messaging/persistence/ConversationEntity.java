package com.allegory.sparrow.web.messaging.persistence;

import com.allegory.sparrow.app.messaging.persistence.ParticipantEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public final class ConversationEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<ParticipantEntity> participants;

    @OneToMany
    private List<MessageEntity> messages;

    private ConversationEntity() {} // For JPA

    public ConversationEntity(final List<ParticipantEntity> participants,
                              final List<MessageEntity> messages) {
        this.participants = participants;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public List<ParticipantEntity> getParticipants() {
        return participants;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }
}
