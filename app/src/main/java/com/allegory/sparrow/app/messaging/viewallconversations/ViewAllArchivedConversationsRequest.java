package com.allegory.sparrow.app.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.ConversationResource;
import com.allegory.sparrow.app.messaging.ConversationsArchive;
import java.util.List;
import java.util.stream.Collectors;

public final class ViewAllArchivedConversationsRequest implements
    ViewAllConversationsRequest
{
    private final ConversationsArchive conversationsArchive;

    public ViewAllArchivedConversationsRequest(
        final ConversationsArchive conversationsArchive)
    {
        this.conversationsArchive = conversationsArchive;
    }

    @Override
    public ViewAllConversationsResponse response()
    {
        final List<ConversationResource> conversationResources =
            conversationsArchive.conversations()
            .stream()
            .map(conversation -> ConversationResource.fromConversation(conversation))
            .collect(Collectors.toList());
        return new ViewAllConversationsResponse(conversationResources);
    }
}
