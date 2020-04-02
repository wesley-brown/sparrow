package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.DeliveredMessage;
import com.allegory.sparrow.domain.messaging.Participant;
import com.allegory.sparrow.domain.messaging.UndeliveredMessage;
import org.junit.jupiter.api.Test;

final class MessagingTest {

    @Test
    void delivering_an_undelivered_message_returns_an_equivalent_delivered_one() {
        final MessageDeliveryService messageDeliveryService =
            new MessageDeliveryService();
        final Participant paul = new Participant("Paul");
        final Participant bob = new Participant("Bob");
        final Conversation paulAndBobsConversation = new Conversation();
        final UndeliveredMessage paulsUndeliveredMessage =
            new UndeliveredMessage(
                paulAndBobsConversation,
                paul,
                "How can I help you today?"
        );
        final DeliveredMessage expectedDeliveredMessage = new DeliveredMessage(
            paul, bob, "How can I help you today?");
        final DeliveredMessage actualDeliveredMessage = messageDeliveryService
            .deliverMessageTo(paulsUndeliveredMessage, bob);
        assertEquals(expectedDeliveredMessage, actualDeliveredMessage);
    }
}
