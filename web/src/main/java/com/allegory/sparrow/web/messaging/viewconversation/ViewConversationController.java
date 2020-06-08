package com.allegory.sparrow.web.messaging.viewconversation;

import com.allegory.sparrow.app.messaging.viewconversation.ViewConversationRequest;
import com.allegory.sparrow.app.messaging.viewconversation.ConversationViewer;
import com.allegory.sparrow.app.messaging.viewconversation.ViewConversationResponse;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller for the view conversation endpoint.
 */
@RestController
final class ViewConversationController
{
    private final ConversationViewer conversationViewer;

    /**
     * Create a new view conversation controller.
     *
     * @param conversationViewer the conversation viewer that will make
     *                           requests to view conversations.
     */
    ViewConversationController(
        final ConversationViewer conversationViewer)
    {
        this.conversationViewer = conversationViewer;
    }

    /**
     * View a conversation with a given ID.
     *
     * @param id the ID of the conversation to view.
     * @return a view of the conversation with the given ID.
     */
    @GetMapping("/api/v1/conversations/{id}")
    ViewConversationWebResponse viewConversationWithId(
        @PathVariable final UUID id)
    {
        final ViewConversationRequest request =
            conversationViewer.requestToViewConversationWithId(id);
        final ViewConversationResponse response = request.response();
        return ViewConversationWebResponse
            .fromViewConversationResponse(response);
    }
}
