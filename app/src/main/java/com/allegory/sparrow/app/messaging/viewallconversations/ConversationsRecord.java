package com.allegory.sparrow.app.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.ConversationResource;
import java.util.List;

/**
 * A record of conversations.
 */
public interface ConversationsRecord
{
    /**
     * The recorded conversations.
     * @return the recoreded conversations.
     */
    List<ConversationResource> conversations();
}
