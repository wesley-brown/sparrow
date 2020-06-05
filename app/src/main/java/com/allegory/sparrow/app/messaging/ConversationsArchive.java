package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Conversation;
import java.util.List;
import java.util.UUID;

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

    Conversation conversationWithId(final UUID id);
}
