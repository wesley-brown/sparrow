package com.allegory.sparrow.app.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.Arrays;
import java.util.UUID;
import org.junit.jupiter.api.Test;

final class When_comparing_conversation_resources
{
    @Test
    void identical_conversation_resources_have_the_same_hash_codes()
    {
        final Participant bob =
            Participant.withIdAndName(UUID.randomUUID(), "Bob");
        final Participant alice =
            Participant.withIdAndName(UUID.randomUUID(), "Alice");
        final Message bobsMessage =
            Message.withIdFromSenderWithContent(
                UUID.randomUUID(), bob, "Hey Alice, how are you?");
        final Conversation bobAndAlicesConversation =
            Conversation.withIdBetweenParticipantsWithMessages(
                UUID.randomUUID(),
                Arrays.asList(bob, alice),
                Arrays.asList(bobsMessage));
        final ConversationResource bobAndAlicesConversationResource =
            ConversationResource.fromConversation(bobAndAlicesConversation);
        final ConversationResource bobAndAlicesDuplicateConversationResource =
            ConversationResource.fromConversation(bobAndAlicesConversation);
        assertEquals(
            bobAndAlicesConversationResource.hashCode(),
            bobAndAlicesDuplicateConversationResource.hashCode());
    }
}
