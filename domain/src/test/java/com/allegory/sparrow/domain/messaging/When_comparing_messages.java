package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_messages
{
    private Participant bob;
    private Message bobsMessage;
    private Message bobsDuplicateMessage;

    @BeforeEach
    void setUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        bobsMessage = Message.withIdFromSenderWithContent(
            UUID.randomUUID(), bob, "Hello, World!");
        bobsDuplicateMessage = Message.withIdFromSenderWithContent(
            bobsMessage.id(), bobsMessage.sender(), bobsMessage.content());
    }

    @AfterEach
    void tearDown()
    {
        bob = null;
        bobsMessage = null;
        bobsDuplicateMessage = null;
    }

    @Test
    void messages_with_the_same_id_have_the_same_hash_codes()
    {
        assertEquals(bobsMessage.hashCode(), bobsDuplicateMessage.hashCode());
    }

    @Test
    void messages_with_the_same_id_are_equal()
    {
        assertEquals(bobsMessage, bobsDuplicateMessage);
    }
}
