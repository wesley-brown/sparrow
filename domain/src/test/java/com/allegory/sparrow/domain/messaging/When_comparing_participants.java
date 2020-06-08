package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_participants
{
    @Test
    void participants_with_the_same_id_have_the_same_hash_codes()
    {
        final Participant paul = Participant.withIdAndName(
            UUID.randomUUID(), "Paul");
        final Participant paulsClone = Participant.withIdAndName(
            paul.id(), paul.name());
        assertEquals(paul.hashCode(), paulsClone.hashCode());
    }
}
