package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Participant;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

/**
 * A web resource for a participant.
 */
public final class ParticipantResource
{
    private final UUID participantId;
    private final String participantName;

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

    private ParticipantResource(
        final UUID participantId,
        final String participantName)
    {
        this.participantId = participantId;
        this.participantName = participantName;
    }

    @JsonProperty
    public UUID participantId()
    {
        return participantId;
    }

    @JsonProperty
    public String name()
    {
        return participantName;
    }
}
