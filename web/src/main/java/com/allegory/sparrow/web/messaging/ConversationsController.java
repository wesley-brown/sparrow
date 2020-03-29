package com.allegory.sparrow.web.messaging;

import java.util.List;

/**
 * A REST controller for conversation endpoints.
 */
final class ConversationsController {
    private List<ConversationResponse> conversations;

    /**
     * Create a new conversations controller.
     *
     * @param conversations the conversations this conversations controller
     *                      initially knows about.
     */
    ConversationsController(final List<ConversationResponse> conversations) {
        this.conversations = conversations;
    }

    /**
     * Get a conversation by a given ID.
     *
     * @param id the unique ID of the conversation.
     * @return the conversation with the given ID.
     */
    ConversationResponse getConversationById(long id) {
        ConversationResponse requestedConversation = null;
        for (final ConversationResponse conversation : conversations) {
            if (conversation.id() == id) {
                requestedConversation = conversation;
            }
        }
        return requestedConversation;
    }
}
