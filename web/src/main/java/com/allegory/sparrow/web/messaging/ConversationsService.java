package com.allegory.sparrow.web.messaging;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A service that provides conversations.
 */
@Service
final class ConversationsService {
    private final List<ConversationResponse> conversations;

    /**
     * Create a new conversations service.
     *
     * @param conversations the initial conversations the new conversations
     *                      service will know about.
     */
    ConversationsService(final List<ConversationResponse> conversations) {
        this.conversations = conversations;
    }

    /**
     * Find a conversation by a unique ID.
     *
     * @param id the unique ID of the conversation to find.
     * @return the found conversation or null if no conversation with the given
     *         ID was found.
     */
    ConversationResponse findById(long id) {
        ConversationResponse requestedResponse = null;
        for (final ConversationResponse conversation : conversations) {
            if (conversation.id() == id) {
                requestedResponse = conversation;
                break;
            }
        }
        return requestedResponse;
    }
}
