package com.allegory.sparrow.app.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.ConversationResource;
import com.allegory.sparrow.app.messaging.ConversationsArchive;
import com.allegory.sparrow.domain.messaging.Conversation;
import java.util.ArrayList;
import java.util.List;

/**
 * A record of all conversations.
 */
public final class AllConversationsRecord implements ConversationsRecord
{
    private final ConversationsArchive conversationsArchive;

    public AllConversationsRecord(
        final ConversationsArchive conversationsArchive)
    {
        this.conversationsArchive = conversationsArchive;
    }

    @Override
    public List<ConversationResource> conversations()
    {
        final List<Conversation> conversations = conversationsArchive
            .conversations();
        final List<ConversationResource> conversationResources =
            new ArrayList<>();
        for (final Conversation conversation : conversations)
        {
            final ConversationResource conversationResource =
                ConversationResource.fromConversation(conversation);
            conversationResources.add(conversationResource);
        }
        return conversationResources;
    }
}
