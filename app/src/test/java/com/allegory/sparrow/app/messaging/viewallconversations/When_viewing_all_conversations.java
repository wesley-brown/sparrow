package com.allegory.sparrow.app.messaging.viewallconversations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.app.messaging.ConversationResource;
import com.allegory.sparrow.app.messaging.ConversationsArchive;
import com.allegory.sparrow.app.messaging.MockConversationsArchive;
import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class When_viewing_all_conversations
{
    private Participant bob;
    private Participant alice;
    private Participant paul;
    private Conversation bobAndAlicesConversation;
    private Conversation bobAndPaulsConversation;
    private List<Conversation> conversations;
    private ConversationsArchive conversationsArchive;
    private ViewAllConversationsRequest viewAllConversationsRequest;

    @BeforeEach
    void setUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        alice = Participant.withIdAndName(UUID.randomUUID(), "Alice");
        paul = Participant.withIdAndName(UUID.randomUUID(), "Paul");
        bobAndAlicesConversation = Conversation.withIdBetweenParticipants(
            UUID.randomUUID(), Arrays.asList(bob, alice));
        bobAndPaulsConversation = Conversation.withIdBetweenParticipants
            (UUID.randomUUID(), Arrays.asList(bob, paul));
        conversations = Arrays.asList(
            bobAndAlicesConversation, bobAndPaulsConversation);
        conversationsArchive = new MockConversationsArchive(conversations);
        viewAllConversationsRequest =
            new ViewAllArchivedConversationsRequest(conversationsArchive);
    }

    @AfterEach
    void tearDown()
    {
        bob = null;
        alice = null;
        paul = null;
        bobAndAlicesConversation = null;
        bobAndPaulsConversation = null;
        conversations = null;
        conversationsArchive = null;
        viewAllConversationsRequest = null;
    }

    @Test
    void all_conversations_are_returned()
    {
        final ViewAllConversationsResponse viewAllConversationsResponse =
            viewAllConversationsRequest.response();
        final List<ConversationResource> expectedConversations =
            conversations
            .stream()
            .map(conversation -> ConversationResource.fromConversation(conversation))
            .collect(Collectors.toList());
        assertEquals(
            expectedConversations,
            viewAllConversationsResponse.conversations());
    }
}
