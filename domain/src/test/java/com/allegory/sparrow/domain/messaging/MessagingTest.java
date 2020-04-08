package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

final class MessagingTest {
    private Participant paul;
    private Participant bob;
    private Message paulsMessage;
    private Conversation paulAndBobsConversation;

    @BeforeEach
    void setUp() {
        paul = new Participant("Paul");
        bob = new Participant("Bob");
        paulsMessage = new Message(paul, bob, "How can I help you?");
        paulAndBobsConversation = new Conversation(Arrays.asList(paul, bob));
    }

    @AfterEach
    void tearDown() {
        paul = null;
        bob = null;
        paulsMessage = null;
        paulAndBobsConversation = null;
    }

    @Test
    void identical_participants_are_unique() {
        final Participant paulsClone = new Participant("Paul");
        assertNotEquals(paul, paulsClone);
    }

    @Test
    void identical_messages_are_unique() {
        final Message paulsDuplicateMessage =
            new Message(paul, bob, "How can I help you?");
        assertNotEquals(paulsMessage, paulsDuplicateMessage);
    }

    @Test
    void including_a_message_in_a_conversation_adds_it_to_that_conversations_messages() {
        paulAndBobsConversation.includeMessage(paulsMessage);
        final List<Message> actualMessages = paulAndBobsConversation.messages();
        final List<Message> expectedMessages = Arrays.asList(paulsMessage);
        assertEquals(expectedMessages, actualMessages);
    }
}
