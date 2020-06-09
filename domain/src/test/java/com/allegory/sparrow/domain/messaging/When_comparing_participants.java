package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_participants
{
    private Participant paul;
    private Participant paulsClone;

    @BeforeEach
    void setUp()
    {
        paul = Participant.withIdAndName(UUID.randomUUID(), "Paul");
        paulsClone = Participant.withIdAndName(paul.id(), paul.name());
    }

    @AfterEach
    void tearDown()
    {
        paul = null;
        paulsClone = null;
    }

    @Test
    void participants_with_the_same_id_have_the_same_hash_codes()
    {
        assertEquals(paul.hashCode(), paulsClone.hashCode());
    }

    @Test
    void participants_with_the_same_id_are_equal()
    {
        assertEquals(paul, paulsClone);
    }
}
