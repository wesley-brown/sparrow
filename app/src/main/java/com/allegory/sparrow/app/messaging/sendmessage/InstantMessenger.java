package com.allegory.sparrow.app.messaging.sendmessage;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import java.util.UUID;

/**
 * Delivers messages.
 */
public final class InstantMessenger implements Sender
{
    private final MessageDeliveryArchive messageDeliveryArchive;

    public InstantMessenger(
        final MessageDeliveryArchive messageDeliveryArchive)
    {
        this.messageDeliveryArchive = messageDeliveryArchive;
    }

    @Override
    public void deliverMessage(UndeliveredMessage undeliveredMessage)
    {
        Conversation conversation = messageDeliveryArchive.conversationWithId(
            undeliveredMessage.conversationId());
        final Participant sender = messageDeliveryArchive.participantWithId(
            undeliveredMessage.senderId());
        final Message message = Message.withIdFromSenderWithContent(
            UUID.randomUUID(), sender, undeliveredMessage.content());
        conversation = conversation.includeMessage(message);
        messageDeliveryArchive.saveMessageToConversation(message, conversation);
    }
}
