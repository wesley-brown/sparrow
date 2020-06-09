package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_messages
{
    @Test
    void messages_with_the_same_id_have_the_same_hash_codes()
    {
        final Participant bob = Participant.withIdAndName(
            UUID.randomUUID(), "Bob");
        final Message bobsMessage = Message.withIdFromSenderWithContent(
            UUID.randomUUID(), bob, "Hello, World!");
        final Message bobsDuplicateMessage =
            Message.withIdFromSenderWithContent(
                bobsMessage.id(), bobsMessage.sender(), bobsMessage.content());
        assertEquals(bobsMessage.hashCode(), bobsDuplicateMessage.hashCode());
    }
}
