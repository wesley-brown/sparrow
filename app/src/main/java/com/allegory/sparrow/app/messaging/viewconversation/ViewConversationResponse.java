package com.allegory.sparrow.app.messaging.viewconversation;

import com.allegory.sparrow.domain.messaging.Conversation;

/**
 * A response for a view conversation request.
 */
public final class ViewConversationResponse
{
    private final Conversation conversation;

    /**
     * Create a new view conversation response.
     *
     * @param conversation the conversation to respond with.
     */
    public ViewConversationResponse(final Conversation conversation)
    {
        this.conversation = conversation;
    }

    /**
     * The conversation contained within this view conversation response.
     *
     * @return the conversation.
     */
    public Conversation conversation()
    {
        return conversation;
    }
}
