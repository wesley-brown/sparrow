package com.allegory.sparrow.app.messaging.viewconversation;

import com.allegory.sparrow.app.messaging.ConversationsArchive;
import java.util.UUID;

/**
 * Makes requests to view conversations.
 */
public final class ConversationViewer
{
    private final ConversationsArchive conversationsArchive;

    /**
     * Create a new conversation viewer.
     *
     * @param conversationsArchive the archived to view conversations from.
     */
    public ConversationViewer(
        final ConversationsArchive conversationsArchive)
    {
        this.conversationsArchive = conversationsArchive;
    }

    /**
     * Request to view a conversation with a given ID.
     *
     * @param id the ID of the conversation to view.
     * @return a request to view a conversation with the given ID.
     */
    public ViewConversationRequest requestToViewConversationWithId(
        final UUID id)
    {
        return new ViewArchivedConversationRequest(conversationsArchive, id);
    }
}
