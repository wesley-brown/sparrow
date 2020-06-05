package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import org.junit.jupiter.api.Test;
import java.util.UUID;

final class When_comparing_message_resources
{
    @Test
    void identical_message_resources_have_the_same_hash_codes()
    {
        final Participant bob =
            Participant.withIdAndName(UUID.randomUUID(), "Bob");
        final Message bobsMessage = Message.withIdFromSenderWithContent(
            UUID.randomUUID(), bob, "Hello!");
        final MessageResource bobsMessageResource =
            MessageResource.fromMessage(bobsMessage);
        final MessageResource bobsDuplicateMessageResource =
            MessageResource.fromMessage(bobsMessage);
        assertEquals(
            bobsMessageResource.hashCode(),
            bobsDuplicateMessageResource.hashCode());
    }
}
