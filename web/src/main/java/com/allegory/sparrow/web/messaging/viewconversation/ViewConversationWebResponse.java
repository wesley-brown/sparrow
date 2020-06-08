package com.allegory.sparrow.web.messaging.viewconversation;

import com.allegory.sparrow.app.messaging.ConversationResource;
import com.allegory.sparrow.app.messaging.viewconversation.ViewConversationResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A web-based response to a web-based request to view a conversation resource.
 */
public final class ViewConversationWebResponse
{
    private final ViewConversationResponse viewConversationResponse;

    /**
     * Create a new view conversation web response from a given view
     * conversation response.
     *
     * @param response the view conversation response.
     * @return a new view conversation web response.
     */
    public static ViewConversationWebResponse fromViewConversationResponse(
        final ViewConversationResponse response)
    {
        return new ViewConversationWebResponse(response);
    }

    private ViewConversationWebResponse(
        final ViewConversationResponse viewConversationResponse)
    {
        this.viewConversationResponse = viewConversationResponse;
    }

    /**
     * The conversation resource that this view conversation web response
     * was far.
     *
     * @return the conversation resource.
     */
    @JsonProperty
    public ConversationResource conversation()
    {
        return viewConversationResponse.resource();
    }
}
