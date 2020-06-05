package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Participant;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * A web resource for a participant.
 */
public final class ParticipantResource
{
    private final Participant participant;

    /**
     * Create a new participant resource from a given participant.
     *
     * @param participant the participant to create the new participant from.
     * @return the newly created participant resource.
     */
    public static ParticipantResource fromParticipant(
        final Participant participant)
    {
        return new ParticipantResource(participant);
    }

    private ParticipantResource(final Participant participant)
    {
        this.participant = participant;
    }

    @JsonProperty
    public UUID id()
    {
        return participant.id();
    }

    @JsonProperty
    public String name()
    {
        return participant.name();
    }

    @Override
    public int hashCode()
    {
        // Uses the Effective Java 3 Item 11 algorithm
        final int result = participant.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object other)
    {
        if (other == this)
        {
            return true;
        }
        if (!(other instanceof ParticipantResource))
        {
            return false;
        }
        final ParticipantResource otherResource =
            (ParticipantResource) other;
        return otherResource.participant.equals(this.participant);
    }

    @Override
    public String toString()
    {
        return "<ParticipantResource:" + " id=" + id() + ", name=" + name()
            + ">";
    }
}
