package com.allegory.sparrow.app.messaging.viewconversation;

import com.allegory.sparrow.app.messaging.ConversationResource;
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
    private final UUID conversationId;

    /**
     * Create a new view archived conversation request.
     *
     * @param conversationsArchive the conversations archive from which to get
     *                             the requested archived conversation.
     * @param conversationId the ID of the archived conversation to view.
     */
    public ViewArchivedConversationRequest(
        final ConversationsArchive conversationsArchive,
        final UUID conversationId)
    {
        this.conversationsArchive = conversationsArchive;
        this.conversationId = conversationId;
    }

    @Override
    public ViewConversationResponse response()
    {
        final Conversation conversation =
            conversationsArchive.conversationWithId(conversationId);
        final ConversationResource resource =
            ConversationResource.fromConversation(conversation);
        return new ViewConversationResponse(resource);
    }
}
