package com.allegory.sparrow.web.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.ConversationResource;
import com.allegory.sparrow.app.messaging.viewallconversations.ConversationsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * A REST controller for the view all conversations endpoint.
 */
@RestController
final class ViewAllConversationsController
{
    private final ConversationsRecord conversationsRecord;

    /**
     * Create a new view all conversations controller.
     * @param conversationsRecord the record of conversations to use.
     */
    @Autowired
    ViewAllConversationsController(
        final ConversationsRecord conversationsRecord)
    {
        this.conversationsRecord = conversationsRecord;
    }

    /**
     * View all conversations.
     *
     * @return all conversations.
     */
    @GetMapping("api/v1/conversations")
    List<ConversationResource> viewAllConversations()
    {
        return conversationsRecord.conversations();
    }
}
