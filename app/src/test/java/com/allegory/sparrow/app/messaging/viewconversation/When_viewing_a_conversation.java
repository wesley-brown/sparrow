package com.allegory.sparrow.app.messaging.viewconversation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.app.messaging.MockConversationsArchive;
import com.allegory.sparrow.app.messaging.ConversationsArchive;
import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

final class When_viewing_a_conversation
{
    private Participant bob;
    private Participant paul;
    private Participant alice;
    private Conversation bobAndAlicesConversation;
    private Conversation paulAndAlicesConversation;
    private List<Conversation> conversations;
    private ConversationsArchive conversationsArchive;
    private ViewConversationRequest requestForBobAndAlicesConversation;

    @BeforeEach
    void setUp()
    {
        bob = Participant.withIdAndName(UUID.randomUUID(), "Bob");
        paul = Participant.withIdAndName(UUID.randomUUID(), "Paul");
        alice = Participant.withIdAndName(UUID.randomUUID(), "Alice");
        bobAndAlicesConversation = Conversation.withIdBetweenParticipants(
            UUID.randomUUID(),
            Arrays.asList(bob, alice));
        paulAndAlicesConversation = Conversation.withIdBetweenParticipants(
            UUID.randomUUID(),
            Arrays.asList(paul, alice));
        conversations = Arrays.asList(
            bobAndAlicesConversation,
            paulAndAlicesConversation);
        conversationsArchive = new MockConversationsArchive(conversations);
        requestForBobAndAlicesConversation =
            new ViewArchivedConversationRequest(
                conversationsArchive,
                bobAndAlicesConversation.id());
    }

    @AfterEach
    void tearDown()
    {
        bob = null;
        paul = null;
        alice = null;
        bobAndAlicesConversation = null;
        paulAndAlicesConversation = null;
        conversations = null;
        conversationsArchive = null;
        requestForBobAndAlicesConversation = null;
    }

    @Nested
    final class That_exists
    {
        @Test
        void it_is_returned()
        {
            final ViewConversationResponse response =
                requestForBobAndAlicesConversation.response();
            assertEquals(bobAndAlicesConversation, response.conversation());
        }
    }
}
