package com.allegory.sparrow.app.messaging.viewconversation;

/**
 * A request to view a conversation.
 */
public interface ViewConversationRequest
{
    /**
     * The view conversation response of this view conversation request.
     * @return the view conversation response.
     */
    ViewConversationResponse response();
}
