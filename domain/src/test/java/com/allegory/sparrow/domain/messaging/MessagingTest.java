package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

final class MessagingTest {

    @Test
    void identical_participants_have_same_hash_codes() {
        final Participant bob = new Participant("Bob");
        final Participant bobsClone = new Participant("Bob");
        assertEquals(bob.hashCode(), bobsClone.hashCode());
    }
}
