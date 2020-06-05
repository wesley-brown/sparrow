package com.allegory.sparrow.app.messaging.viewconversation;

import com.allegory.sparrow.app.messaging.ConversationsArchive;
import com.allegory.sparrow.domain.messaging.Conversation;
import java.util.UUID;

/**
 * A request to view an archived conversation.
 */
public final class ViewArchivedConversationRequest implements
    ViewConversationRequest
{
    private final ConversationsArchive conversationsArchive;

    /**
     * Create a new view archived conversation request.
     *
     * @param conversationsArchive the conversations archive to get the
     *                             requested conversation to view from.
     */
    public ViewArchivedConversationRequest(
        final ConversationsArchive conversationsArchive)
    {
        this.conversationsArchive = conversationsArchive;
    }

    @Override
    public ViewConversationResponse conversationWithId(
        final UUID conversationId)
    {
        final Conversation conversation =
            conversationsArchive.conversationWithId(conversationId);
        return new ViewConversationResponse(conversation);
    }
}
