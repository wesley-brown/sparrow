package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Tests related to sending messages.
 */
final class MessageSendingTest {

    @Test
    void delivering_a_message_returns_that_message() {
        final Participant paul = new Participant("Paul");
        final Participant bob = new Participant("Bob");
        final Message paulsMessage =
            new Message(paul, bob, "How can I help you?");
        final Conversation paulAndBobsConversation =
            new Conversation(Arrays.asList(paul, bob));
        final MessageDelivery messageDelivery
            = MessageDelivery.forConversation(paulAndBobsConversation);
        final Message actualDeliveredMessage =
            messageDelivery.deliverMessage(paulsMessage);
        assertEquals(paulsMessage, actualDeliveredMessage);
    }
}
