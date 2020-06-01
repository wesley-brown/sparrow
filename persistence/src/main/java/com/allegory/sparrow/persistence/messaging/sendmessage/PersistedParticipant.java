package com.allegory.sparrow.persistence.messaging.sendmessage;

import com.allegory.sparrow.domain.messaging.Participant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class PersistedParticipant
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private PersistedParticipant() {}  // For JPA

    public static PersistedParticipant fromParticipant(
        final Participant participant)
    {
        return new PersistedParticipant(participant.name());
    }

    public PersistedParticipant(final String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Participant participant()
    {
        return new Participant(name);
    }

    @Override
    public String toString()
    {
        return "<id=" + id + ", name=" + name + ">";
    }
}
