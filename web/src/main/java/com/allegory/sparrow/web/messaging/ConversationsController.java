package com.allegory.sparrow.web.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller for conversation endpoints.
 */
@RestController
final class ConversationsController {
    private ConversationsService conversationsService;

    /**
     * Create a new conversations controller.
     *
     * @param conversationsService the conversations service that the new
     *                             conversations controller will use.
     */
    @Autowired
    ConversationsController(final ConversationsService conversationsService) {
        this.conversationsService = conversationsService;
    }

    /**
     * Get a conversation by a given ID.
     *
     * @param id the unique ID of the conversation.
     * @return the conversation with the given ID.
     */
    @GetMapping("/api/v1/conversations/{id}")
    ConversationResponse getConversationById(@PathVariable long id) {
        return conversationsService.findById(id);
    }
}
