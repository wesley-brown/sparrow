package com.allegory.sparrow.domain.messaging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MessagingTest {
    private Participant paul;
    private Participant bob;
    private DeliveredMessage paulsMessage;

    @BeforeEach
    void setUp() {
        paul = new Participant("Paul");
        bob = new Participant("Bob");
        paulsMessage =
            new DeliveredMessage(paul, bob, "How can I help you?");
    }

    @AfterEach
    void tearDown() {
        paul = null;
        bob = null;
        paulsMessage = null;
    }

    @Test
    void identical_participants_have_same_hash_codes() {
        final Participant paulsClone = new Participant("Paul");
        assertEquals(paul.hashCode(), paulsClone.hashCode());
    }

    @Test
    void identical_participants_are_equal() {
        final Participant paulsClone = new Participant("Paul");
        assertEquals(paul, paulsClone);
    }

    @Test
    void identical_delivered_messages_have_same_hash_codes() {
        final DeliveredMessage paulsDuplicateMessage =
            new DeliveredMessage(paul, bob, "How can I help you?");
        assertEquals(paulsMessage.hashCode(), paulsDuplicateMessage.hashCode());
    }

    @Test
    void identical_delivered_messages_are_equal() {
        final DeliveredMessage paulsDuplicateMessage =
            new DeliveredMessage(paul, bob, "How can I help you?");
        assertEquals(paulsMessage, paulsDuplicateMessage);
    }

    @Test
    void including_a_delivered_message_adds_it_to_the_list_of_all_delivered_messages() {
        final Conversation paulAndBobsConversation = new Conversation();
        paulAndBobsConversation.includeDeliveredMessage(paulsMessage);
        final List<DeliveredMessage> expectedMessages = new ArrayList<>();
        expectedMessages.add(paulsMessage);
        assertThat(paulAndBobsConversation.deliveredMessages())
            .containsExactlyInAnyOrderElementsOf(expectedMessages);
    }
}
