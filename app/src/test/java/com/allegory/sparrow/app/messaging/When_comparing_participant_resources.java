package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.messaging.Participant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_participant_resources
{
    private Participant bob;
    private ParticipantResource bobsResource;

    @BeforeEach
    void setUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        bobsResource = ParticipantResource.fromParticipant(bob);
    }

    @Test
    void identical_participant_resources_have_the_same_hash_codes()
    {
        final ParticipantResource bobsResourceClone =
            ParticipantResource.fromParticipant(bob);
        assertEquals(bobsResource.hashCode(), bobsResourceClone.hashCode());
    }

    @Test
    void identical_participant_resources_are_equal()
    {
        final ParticipantResource bobsResourceClone =
            ParticipantResource.fromParticipant(bob);
        assertEquals(bobsResource, bobsResourceClone);
    }
}
