package com.allegory.sparrow.app.messaging.viewallconversations;

import com.allegory.sparrow.domain.messaging.Conversation;
import java.util.List;

/**
 * An archive of conversations.
 */
public interface ConversationsArchive
{
    /**
     * The conversations contained in this archive.
     * @return the archived conversations.
     */
    List<Conversation> conversations();
}
