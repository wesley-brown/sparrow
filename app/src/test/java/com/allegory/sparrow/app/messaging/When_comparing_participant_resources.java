package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_participant_resources
{
    private ParticipantResource bob;

    @BeforeEach
    void setUp()
    {
        bob = new ParticipantResource(UUID.randomUUID(), "Bob");
    }

    @Test
    void identical_participant_resources_have_the_same_hash_codes()
    {
        final ParticipantResource bobsClone =
            new ParticipantResource(bob.id(), bob.name());
        assertEquals(bob.hashCode(), bobsClone.hashCode());
    }

    @Test
    void identical_participant_resources_are_equal()
    {
        final ParticipantResource bobsClone =
            new ParticipantResource(bob.id(), bob.name());
        assertEquals(bob, bobsClone);
    }
}
