package com.allegory.sparrow.web.messaging.persistence;

import javax.persistence.*;

@Entity
public final class ParticipantEntity {

    @Id
    @GeneratedValue
    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name="conversation_id")
//    private ConversationEntity conversation;

    private String name;

    private ParticipantEntity() {} // For JPA

    public ParticipantEntity(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
