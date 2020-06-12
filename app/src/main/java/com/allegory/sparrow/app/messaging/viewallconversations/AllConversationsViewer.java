package com.allegory.sparrow.app.messaging.viewallconversations;

import com.allegory.sparrow.app.messaging.ConversationsArchive;

public final class AllConversationsViewer
{
    private final ConversationsArchive conversationsArchive;

    public AllConversationsViewer(
        final ConversationsArchive conversationsArchive)
    {
        this.conversationsArchive = conversationsArchive;
    }

    public ViewAllConversationsRequest requestToViewAllConversations()
    {
        return new ViewAllArchivedConversationsRequest(conversationsArchive);
    }
}
