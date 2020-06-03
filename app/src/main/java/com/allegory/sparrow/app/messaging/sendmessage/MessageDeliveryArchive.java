package com.allegory.sparrow.app.messaging.sendmessage;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.UUID;

/**
 * An archive of message deliveries.
 */
public interface MessageDeliveryArchive
{
    Conversation conversationWithId(final UUID id);
    void saveMessageToConversation(final Message message, final Conversation conversation);
    Participant participantWithId(final UUID id);
}
