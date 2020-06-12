package com.allegory.sparrow.web.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.viewallconversations.AllConversationsViewer;
import com.allegory.sparrow.app.messaging.viewallconversations.ViewAllConversationsRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller for the view all conversations endpoint.
 */
@RestController
final class ViewAllConversationsController
{
    private final AllConversationsViewer allConversationsViewer;

    /**
     * Create a new view all conversations controller.
     * @param allConversationsViewer the all conversations viewer to create
     *                               view all conversation requests from.
     */
    ViewAllConversationsController(
        final AllConversationsViewer allConversationsViewer)
    {
        this.allConversationsViewer = allConversationsViewer;
    }

    /**
     * View all conversations.
     *
     * @return all conversations.
     */
    @GetMapping("api/v1/conversations")
    ViewAllConversationsWebResponse viewAllConversations()
    {
        final ViewAllConversationsRequest request =
            allConversationsViewer.requestToViewAllConversations();
        final ViewAllConversationsWebResponse response =
            ViewAllConversationsWebResponse.fromViewAllConversationsResponse(
                request.response());
        return response;
    }
}
