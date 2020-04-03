package com.allegory.sparrow.domain.messaging;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MessagingTest {
    private Participant paul;
    private Participant bob;
    private DeliveredMessage paulsMessage;
    private Conversation paulAndBobsConversation;
    private UndeliveredMessage bobsUndeliveredMessage;

    @BeforeEach
    void setUp() {
        paul = new Participant("Paul");
        bob = new Participant("Bob");
        paulsMessage =
            new DeliveredMessage(paul, bob, "How can I help you?");
        paulAndBobsConversation = new Conversation();
        bobsUndeliveredMessage = new UndeliveredMessage(
            paulAndBobsConversation, bob, "I'm looking to buy a house.");
    }

    @AfterEach
    void tearDown() {
        paul = null;
        bob = null;
        paulsMessage = null;
        paulAndBobsConversation = null;
        bobsUndeliveredMessage = null;
    }

    @Test
    void identical_participants_are_unique() {
        final Participant paul = new Participant("Paul");
        final Participant paulsClone = new Participant("Paul");
        assertNotEquals(paul, paulsClone);
    }

    @Test
    void identical_messages_are_unique() {
        final Participant paul = new Participant("Paul");
        final Participant bob = new Participant("Bob");
        final Message paulsMessage = new Message(paul, bob, "How can I help you?");
        final Message paulsDuplicateMessage = new Message(paul, bob, "How can I help you?");
        assertNotEquals(paulsMessage, paulsDuplicateMessage);
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
    void including_a_message_in_a_conversation_adds_it_to_that_conversations_messages() {
        final Participant paul = new Participant("Paul");
        final Participant bob = new Participant("Bob");
        final Conversation paulAndBobsConversation =
            new Conversation(Arrays.asList(paul, bob));
        final Message paulsMessage = new Message(paul, bob, "How can I help you?");
        paulAndBobsConversation.includeMessage(paulsMessage);
        assertThat(paulAndBobsConversation.messages()).contains(paulsMessage);
    }

    @Test
    void including_a_delivered_message_adds_it_to_the_list_of_all_delivered_messages() {
        paulAndBobsConversation.includeDeliveredMessage(paulsMessage);
        final List<DeliveredMessage> expectedMessages = new ArrayList<>();
        expectedMessages.add(paulsMessage);
        assertThat(paulAndBobsConversation.deliveredMessages())
            .containsExactlyInAnyOrderElementsOf(expectedMessages);
    }

    @Test
    void sending_an_undelivered_message_returns_an_equivalent_delivered_message() {
        final DeliveredMessage bobsExpectedDeliveredMessage =
                new DeliveredMessage(bob, paul, "I'm looking to buy a house.");
        final DeliveredMessage bobsActualDeliveredMessage =
            bobsUndeliveredMessage.sendTo(paul);
        assertEquals(bobsExpectedDeliveredMessage, bobsActualDeliveredMessage);
    }

    @Test
    void sending_an_undelivered_message_adds_it_to_the_conversation() {
        final List<DeliveredMessage> expectedMessages = new ArrayList<>();
        expectedMessages.add(new DeliveredMessage(bob, paul, "I'm looking to buy a house."));
        bobsUndeliveredMessage.sendTo(paul);
        assertThat(paulAndBobsConversation.deliveredMessages()).containsExactlyInAnyOrderElementsOf(expectedMessages);
    }
}
