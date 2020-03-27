package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MessagingTest {
    private Participant bob;

    @BeforeEach
    void setUp() {
        bob = new Participant("Bob");
    }

    @AfterEach
    void tearDown() {
        bob = null;
    }

    @Test
    void identical_participants_have_same_hash_codes() {
        final Participant bobsClone = new Participant("Bob");
        assertEquals(bob.hashCode(), bobsClone.hashCode());
    }

    @Test
    void identical_participants_are_equal() {
        final Participant bobsClone = new Participant("Bob");
        assertEquals(bob, bobsClone);
    }
}
