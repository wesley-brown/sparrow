package com.allegory.sparrow.persistence.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.viewallconversations.ConversationsArchive;
import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.persistence.messaging.ConversationRepository;
import com.allegory.sparrow.persistence.messaging.PersistedConversation;
import java.util.ArrayList;
import java.util.List;

/**
 * An in-memory archive of conversations.
 */
public final class InMemoryConversationsArchive implements ConversationsArchive
{
    private final ConversationRepository conversationRepository;

    /**
     * Create a new in-memory conversations archive using the given
     * conversation repository as a source of data.
     *
     * @param conversationRepository the conversation repository to use as a
     *                               source of data.
     */
    public InMemoryConversationsArchive(
        final ConversationRepository conversationRepository)
    {
        this.conversationRepository = conversationRepository;
    }

    @Override
    public List<Conversation> conversations()
    {
        final Iterable<PersistedConversation> persistedConversations =
            conversationRepository.findAll();
        final List<Conversation> conversations = new ArrayList<>();
        for (final PersistedConversation persistedConversation : persistedConversations)
        {
            conversations.add(persistedConversation.conversation());
        }
        return conversations;
    }
}
