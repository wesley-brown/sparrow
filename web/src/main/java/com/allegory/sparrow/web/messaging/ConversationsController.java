package com.allegory.sparrow.web.messaging;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller for conversation endpoints.
 */
@RestController
final class ConversationsController {
    private ConversationsService conversationsService;
    private final AtomicLong counter;

    /**
     * Create a new conversations controller.
     *
     * @param conversationsService the conversations service that the new
     *                             conversations controller will use.
     */
    @Autowired
    ConversationsController(final ConversationsService conversationsService) {
        this.conversationsService = conversationsService;
        counter = new AtomicLong(conversationsService.lastIdUsed());
    }

    @GetMapping("/api/v1/conversations")
    List<ConversationResponse> getAllConversations() {
        return conversationsService.conversations();
    }

    /**
     * Get a conversation by a given ID.
     *
     * @param id the unique ID of the conversation.
     * @return the conversation with the given ID.
     */
    @GetMapping("/api/v1/conversations/{id}")
    ConversationResponse getConversationById(@PathVariable final long id) {
        return conversationsService.findById(id);
    }

    /**
     * Post a new conversation.
     *
     * @param conversation the conversation to post.
     * @return the posted conversation.
     */
    @PostMapping("/api/v1/conversations")
    ConversationResponse postConversation(
        @RequestBody final ConversationRequest conversation) {
        final ConversationResponse createdConversation =
            new ConversationResponse(
                counter.incrementAndGet(),
                conversation.participantNames(),
                new ArrayList<>()
        );
        final ConversationResponse addedConversation =
            conversationsService.addConversation(createdConversation);
        return addedConversation;
    }

    MessageResponse postMessage(final Long conversationId,
                                final MessageRequest message) {
        return new MessageResponse(
            counter.incrementAndGet(),
            message.senderName(),
            message.receiverName(),
            message.content()
        );
    }
}
