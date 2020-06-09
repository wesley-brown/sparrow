package com.allegory.sparrow.domain.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class When_comparing_conversations
{
    private Participant bob;
    private Conversation bobsConversation;
    private Conversation bobsDuplicateConversation;

    @BeforeEach
    void setUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        bobsConversation = Conversation.withIdBetweenParticipants(
            UUID.randomUUID(), Arrays.asList(bob));
        bobsDuplicateConversation = Conversation.withIdBetweenParticipants(
            bobsConversation.id(), bobsConversation.participants());
    }

    @AfterEach
    void tearDown()
    {
        bob = null;
        bobsConversation = null;
        bobsDuplicateConversation = null;
    }

    @Test
    void conversations_with_the_same_id_have_the_same_hash_codes()
    {
        assertEquals(
            bobsConversation.hashCode(), bobsDuplicateConversation.hashCode());
    }

    @Test
    void conversations_with_the_same_id_are_equal()
    {
        assertEquals(bobsConversation, bobsDuplicateConversation);
    }
}
