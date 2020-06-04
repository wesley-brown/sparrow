package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MessagingTest
{
    private Participant paul;
    private Participant bob;
    private Message paulsMessageToBob;
    private Conversation paulAndBobsConversation;

    @BeforeEach
    void setUp()
    {
        paul = Participant.withIdAndName(UUID.randomUUID(), "Paul");
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        paulsMessageToBob = Message.withIdFromSenderWithContent(
            UUID.randomUUID(),
            paul,
            "How can I help you?");
        paulAndBobsConversation = Conversation.withIdBetweenParticipants(
            UUID.randomUUID(),
            Arrays.asList(paul, bob));
    }

    @AfterEach
    void tearDown()
    {
        paul = null;
        bob = null;
        paulsMessageToBob = null;
        paulAndBobsConversation = null;
    }

    @Test
    void identical_participants_are_unique()
    {
        final Participant paulsClone =
            Participant.withIdAndName(UUID.randomUUID(), "Paul");
        assertNotEquals(paul, paulsClone);
    }

    @Test
    void identical_messages_are_unique()
    {
        final Message paulsDuplicateMessage =
            Message.withIdFromSenderWithContent(
                UUID.randomUUID(),
                paul,
                "How can I help you?");
        assertNotEquals(paulsMessageToBob, paulsDuplicateMessage);
    }

    @Test
    void including_a_message_in_a_conversation_adds_it_to_that_conversations_messages()
    {
        paulAndBobsConversation.includeMessage(paulsMessageToBob);
        final List<Message> actualMessages = paulAndBobsConversation.messages();
        final List<Message> expectedMessages = Arrays.asList(paulsMessageToBob);
        assertEquals(expectedMessages, actualMessages);
    }
}
