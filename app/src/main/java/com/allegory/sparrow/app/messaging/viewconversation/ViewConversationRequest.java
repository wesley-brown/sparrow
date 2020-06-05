package com.allegory.sparrow.app.messaging.viewconversation;

import java.util.UUID;

/**
 * A request to view a conversation.
 */
public interface ViewConversationRequest
{
    /**
     * The conversation with the given ID.
     *
     * @param conversationId the ID of the conversation to request.
     * @return a response with the requested conversation.
     */
    ViewConversationResponse conversationWithId(final UUID conversationId);
}
