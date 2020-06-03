package com.allegory.sparrow.app.messaging.viewallconversations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.app.messaging.ConversationResource;
import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class When_viewing_all_conversations
{
    private Participant bob;
    private Participant alice;
    private Participant paul;
    private Conversation bobAndAlicesConversation;
    private Conversation aliceAndPaulsConversation;

    @BeforeEach
    void setUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        alice = Participant.withIdAndName(UUID.randomUUID(), "Alice");
        paul = Participant.withIdAndName(UUID.randomUUID(), "Paul");
        bobAndAlicesConversation = Conversation.withIdBetweenParticipants(
            UUID.randomUUID(), Arrays.asList(bob, alice));
        aliceAndPaulsConversation = Conversation.withIdBetweenParticipants(
            UUID.randomUUID(), Arrays.asList(alice, paul));
    }

    @AfterEach
    void tearDown()
    {
        bob = null;
        alice = null;
        paul = null;
        bobAndAlicesConversation = null;
        aliceAndPaulsConversation = null;
    }

    @Test
    void all_conversations_are_returned()
    {
        final List<Conversation> conversations =
            Arrays.asList(bobAndAlicesConversation, aliceAndPaulsConversation);
        final ConversationsArchive conversationsArchive =
            new MockConversationsArchive(conversations);
        final ConversationsRecord conversationsRecord =
            new AllConversationsRecord(conversationsArchive);

        final List<ConversationResource> expectedConversations = new ArrayList<>();
        expectedConversations.add(ConversationResource.fromConversation(bobAndAlicesConversation));
        expectedConversations.add(ConversationResource.fromConversation(aliceAndPaulsConversation));
        final List<ConversationResource> actualConversations =
            conversationsRecord.conversations();
        assertEquals(expectedConversations, actualConversations);
    }
}
