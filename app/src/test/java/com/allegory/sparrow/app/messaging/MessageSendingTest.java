package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.Arrays;
import java.util.List;

/**
 * Tests related to sending messages.
 */
final class MessageSendingTest {
    private Participant paul;
    private Participant bob;
    private Conversation paulAndBobsConversation;
    private Message paulsMessage;
    private MessageDelivery paulsMessageDelivery;

    @BeforeEach
    void setUp() {
        paul = new Participant("Paul");
        bob = new Participant("Bob");
        paulAndBobsConversation = new Conversation(Arrays.asList(paul, bob));
        paulsMessage = new Message(paul, bob, "How can I help you?");
        paulsMessageDelivery =
            MessageDelivery.forConversation(paulAndBobsConversation);
    }

    @AfterEach
    void tearDown() {
        paul = null;
        bob = null;
        paulAndBobsConversation = null;
        paulsMessage = null;
        paulsMessageDelivery = null;
    }

    @Test
    void delivering_a_message_returns_that_message() {
        final Message actualDeliveredMessage = paulMessagesBob();
        assertEquals(paulsMessage, actualDeliveredMessage);
    }

    @Test
    void delivering_a_message_adds_that_messages_to_its_conversations_messages() {
        final List<Message> expectedMessages = Arrays.asList(paulsMessage);
        paulMessagesBob();
        final List<Message> actualMessages = paulAndBobsConversation.messages();
        assertEquals(expectedMessages, actualMessages);
    }

    private Message paulMessagesBob() {
        return paulsMessageDelivery.deliverMessage(paulsMessage);
    }
}
