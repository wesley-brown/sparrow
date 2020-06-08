package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MessagingTest
{
    private Participant paul;
    private Message paulsMessage;

    @BeforeEach
    void setUp()
    {
        paul = Participant.withIdAndName(UUID.randomUUID(), "Paul");
        paulsMessage = Message.withIdFromSenderWithContent(
            UUID.randomUUID(),
            paul,
            "How can I help you?");
    }

    @AfterEach
    void tearDown()
    {
        paul = null;
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
        assertNotEquals(paulsMessage, paulsDuplicateMessage);
    }
}
