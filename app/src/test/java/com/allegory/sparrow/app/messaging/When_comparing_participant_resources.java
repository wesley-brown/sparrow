package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_participant_resources
{
    @Test
    void identical_participant_resources_have_the_same_hash_codes()
    {
        final UUID bobsId = UUID.randomUUID();
        final ParticipantResource bob =
            new ParticipantResource(bobsId, "Bob");
        final ParticipantResource bobsClone =
            new ParticipantResource(bobsId, "Bob");
        assertEquals(bob.hashCode(), bobsClone.hashCode());
    }
}
