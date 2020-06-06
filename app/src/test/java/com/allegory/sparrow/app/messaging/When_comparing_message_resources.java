package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_message_resources
{
    private Participant bob;
    private Message bobsMessage;
    private MessageResource bobsMessageResource;
    private MessageResource bobsDuplicateMessageResource;

    @BeforeEach
    void setUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        bobsMessage = Message.withIdFromSenderWithContent(
            UUID.randomUUID(), bob, "Hello!");
        bobsMessageResource = MessageResource.fromMessage(bobsMessage);
        bobsDuplicateMessageResource = MessageResource.fromMessage(bobsMessage);
    }

    @AfterEach
    void tearDown()
    {
        bob = null;
        bobsMessage = null;
        bobsMessageResource = null;
        bobsDuplicateMessageResource = null;
    }

    @Test
    void identical_message_resources_have_the_same_hash_codes()
    {
        assertEquals(
            bobsMessageResource.hashCode(),
            bobsDuplicateMessageResource.hashCode());
    }

    @Test
    void identical_message_resources_are_equal()
    {
        assertEquals(bobsMessageResource, bobsDuplicateMessageResource);
    }
}
