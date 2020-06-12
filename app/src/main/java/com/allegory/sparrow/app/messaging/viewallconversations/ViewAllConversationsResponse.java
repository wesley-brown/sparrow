package com.allegory.sparrow.app.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.ConversationResource;
import java.util.ArrayList;
import java.util.List;

/**
 * A response for a view all conversations request.
 */
public final class ViewAllConversationsResponse
{
    private final List<ConversationResource> resources;

    public ViewAllConversationsResponse(final List<ConversationResource> resources)
    {
        this.resources = new ArrayList<>(resources);
    }

    public List<ConversationResource> conversations()
    {
        return new ArrayList<>(resources);
    }
}
