package com.allegory.sparrow.app.messaging.viewallconversations;

import com.allegory.sparrow.domain.messaging.Conversation;
import java.util.ArrayList;
import java.util.List;

final class MockConversationsArchive implements ConversationsArchive
{
    private List<Conversation> conversations;

    MockConversationsArchive(final List<Conversation> conversations)
    {
        this.conversations = new ArrayList<>(conversations);
    }

    @Override
    public List<Conversation> conversations()
    {
        return new ArrayList<>(conversations);
    }
}
