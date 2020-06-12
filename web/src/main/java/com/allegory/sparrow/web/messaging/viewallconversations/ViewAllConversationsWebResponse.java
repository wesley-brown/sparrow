package com.allegory.sparrow.web.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.ConversationResource;
import com.allegory.sparrow.app.messaging.viewallconversations.ViewAllConversationsResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * A web-based response to a web-based requests to view all conversation
 * resources.
 */
public final class ViewAllConversationsWebResponse
{
    private final ViewAllConversationsResponse viewAllConversationsResponse;

    public static ViewAllConversationsWebResponse
        fromViewAllConversationsResponse(
            final ViewAllConversationsResponse viewAllConversationsResponse)
    {
        return new ViewAllConversationsWebResponse(
            viewAllConversationsResponse);
    }

    private ViewAllConversationsWebResponse(
        final ViewAllConversationsResponse viewAllConversationsResponse)
    {
        this.viewAllConversationsResponse = viewAllConversationsResponse;
    }

    @JsonProperty
    public List<ConversationResource> conversations()
    {
        return viewAllConversationsResponse.conversations();
    }
}
