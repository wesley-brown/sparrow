package com.allegory.sparrow.app.messaging.viewconversation;

import com.allegory.sparrow.app.messaging.ConversationResource;

/**
 * A response for a view conversation request.
 */
public final class ViewConversationResponse
{
    private final ConversationResource conversation;

    /**
     * Create a new view conversation response.
     *
     * @param conversation the conversation to respond with.
     */
    public ViewConversationResponse(final ConversationResource conversation)
    {
        this.conversation = conversation;
    }

    /**
     * The conversation resource contained within this view conversation
     * response.
     *
     * @return the conversation resource.
     */
    public ConversationResource resource()
    {
        return conversation;
    }
}
