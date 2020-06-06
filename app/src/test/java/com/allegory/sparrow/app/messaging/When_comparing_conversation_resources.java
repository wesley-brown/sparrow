package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.Arrays;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class When_comparing_conversation_resources
{
    private Participant bob;
    private Participant alice;
    private Message bobsMessage;
    private Conversation bobAndAlicesConversation;
    private ConversationResource bobAndAlicesConversationResource;
    private ConversationResource bobAndAlicesDuplicateConversationResource;

    @BeforeEach
    void SetUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        alice = Participant.withIdAndName(UUID.randomUUID(), "Alice");
        bobsMessage = Message.withIdFromSenderWithContent(
            UUID.randomUUID(), bob, "Hey Alice, how are you?");
        bobAndAlicesConversation =
            Conversation.withIdBetweenParticipantsWithMessages(
                UUID.randomUUID(),
                Arrays.asList(bob, alice),
                Arrays.asList(bobsMessage));
        bobAndAlicesConversationResource =
            ConversationResource.fromConversation(bobAndAlicesConversation);
        bobAndAlicesDuplicateConversationResource =
            ConversationResource.fromConversation(bobAndAlicesConversation);
    }

    @AfterEach
    void tearDown()
    {
        bob = null;
        alice = null;
        bobsMessage = null;
    }

    @Test
    void identical_conversation_resources_have_the_same_hash_codes()
    {
        assertEquals(
            bobAndAlicesConversationResource.hashCode(),
            bobAndAlicesDuplicateConversationResource.hashCode());
    }

    @Test
    void identical_conversation_resources_are_equal()
    {
        assertEquals(
            bobAndAlicesConversationResource,
            bobAndAlicesDuplicateConversationResource);
    }
}
