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
     * Add a given conversation to the list of all conversations.
     *
     * @param conversationToAdd the conversation to add.
     * @return the added conversation.
     */
    ConversationResponse addConversation(
        final ConversationResponse conversationToAdd) {
        conversations.add(conversationToAdd);
        return conversationToAdd;
    }

    List<ConversationResponse> conversations() {
        return conversations;
    }

    /**
     * The last unique conversation ID number that was used.
     *
     * @return the last unique Conversation ID number that was used.
     */
    Long lastIdUsed() {
        Long maxId = new Long(1);
        for (final ConversationResponse conversation : conversations) {
            if (conversation.id() > maxId) {
                maxId = conversation.id();
            }
        }
        return maxId;
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
