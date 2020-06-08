package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

final class When_sending_a_message
{
    private Participant bob;
    private Conversation bobsConversation;
    private Message bobsMessage;

    @BeforeEach
    void setUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        bobsConversation = Conversation.withIdBetweenParticipants(
            UUID.randomUUID(), Arrays.asList(bob));
        bobsMessage = Message.withIdFromSenderWithContent(
            UUID.randomUUID(), bob, "Hello!");
    }

    @AfterEach
    void tearDown()
    {
        bob = null;
        bobsConversation = null;
        bobsMessage = null;
    }

    @Test
    void that_message_is_included_in_the_conversation()
    {
        final List<Message> expectedMessages = bobsConversation
            .messages();
        expectedMessages.add(bobsMessage);
        bobsConversation = bobsConversation.includeMessage(
            bobsMessage);
        assertEquals(expectedMessages, bobsConversation.messages());
    }
}
