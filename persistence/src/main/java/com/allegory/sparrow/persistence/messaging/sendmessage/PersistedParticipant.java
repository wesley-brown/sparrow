package com.allegory.sparrow.persistence.messaging.sendmessage;

import com.allegory.sparrow.domain.messaging.Participant;
import java.util.UUID;
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
    private UUID participantId;
    private String name;

    private PersistedParticipant() {}  // For JPA

    public static PersistedParticipant fromParticipant(
        final Participant participant)
    {
        return new PersistedParticipant(participant.id(), participant.name());
    }

    public PersistedParticipant(final UUID participantId, final String name)
    {
        this.participantId = participantId;
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public UUID getParticipantId()
    {
        return participantId;
    }

    public String getName()
    {
        return name;
    }

    public Participant participant()
    {
        return Participant.withIdAndName(participantId, name);
    }

    @Override
    public String toString()
    {
        return "<id=" + getId() + ", participantId= " + getParticipantId()
            + ", name=" + name + ">";
    }
}
