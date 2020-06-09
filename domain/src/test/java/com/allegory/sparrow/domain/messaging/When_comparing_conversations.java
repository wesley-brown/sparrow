package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.UUID;

final class When_comparing_conversations
{
    @Test
    void conversations_with_the_same_id_have_the_same_hash_codes()
    {
        final Participant bob = Participant.withIdAndName(
            UUID.randomUUID(), "Bob");
        final Conversation bobsConversation = Conversation
            .withIdBetweenParticipants(UUID.randomUUID(), Arrays.asList(bob));
        final Conversation bobsDuplicateConversation = Conversation
            .withIdBetweenParticipants(
                bobsConversation.id(), bobsConversation.participants());
        assertEquals(
            bobsConversation.hashCode(), bobsDuplicateConversation.hashCode());
    }
}
