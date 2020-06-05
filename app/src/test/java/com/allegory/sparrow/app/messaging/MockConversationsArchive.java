package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.Conversation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class MockConversationsArchive implements ConversationsArchive
{
    private List<Conversation> conversations;

    public MockConversationsArchive(final List<Conversation> conversations)
    {
        this.conversations = new ArrayList<>(conversations);
    }

    @Override
    public List<Conversation> conversations()
    {
        return new ArrayList<>(conversations);
    }

    @Override
    public Conversation conversationWithId(final UUID id)
    {
        Conversation requestedConversation = null;
        for (final Conversation conversation : conversations)
        {
            if (conversation.id().equals(id))
            {
                requestedConversation = conversation;
                break;
            }
        }
        return requestedConversation;
    }
}
