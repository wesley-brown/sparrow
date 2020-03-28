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

    @Test
    void identical_delivered_messages_have_same_hash_codes() {
        final Participant paul = new Participant("Paul");
        final DeliveredMessage paulsMessage =
            new DeliveredMessage(paul, bob, "How can I help you?");
        final DeliveredMessage paulsDuplicateMessage =
            new DeliveredMessage(paul, bob, "How can I help you?");
        assertEquals(paulsMessage.hashCode(), paulsDuplicateMessage.hashCode());
    }
}
