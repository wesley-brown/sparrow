package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Participant;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * A web resource for a participant.
 */
public final class ParticipantResource
{
    private final UUID id;
    private final String name;

    /**
     * Create a new participant resource from a given participant.
     *
     * @param participant the participant to create the new participant from.
     * @return the newly created participant resource.
     */
    public static ParticipantResource fromParticipant(
        final Participant participant)
    {
        return new ParticipantResource(participant.id(), participant.name());
    }

    public ParticipantResource(
        final UUID id,
        final String name)
    {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public UUID id()
    {
        return id;
    }

    @JsonProperty
    public String name()
    {
        return name;
    }

    @Override
    public int hashCode()
    {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
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
        return otherResource.id.equals(this.id)
            && otherResource.name.equals(this.name);
    }

    @Override
    public String toString()
    {
        return "<ParticipantResource:" + " id=" + id + ", name=" + name + ">";
    }
}
