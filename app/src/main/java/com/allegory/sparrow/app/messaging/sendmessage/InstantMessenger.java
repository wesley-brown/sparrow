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
    private final Receiver receiver;
    private final MessageDeliveryArchive messageDeliveryArchive;

    public InstantMessenger(
        final Receiver receiver,
        final MessageDeliveryArchive messageDeliveryArchive)
    {
        this.receiver = receiver;
        this.messageDeliveryArchive = messageDeliveryArchive;
    }

    @Override
    public void deliverMessage(UndeliveredMessage undeliveredMessage)
    {
        final Conversation conversation =
            messageDeliveryArchive
            .conversationWithId(undeliveredMessage.conversationId());
        final Participant sender =
            messageDeliveryArchive
            .participantWithId(undeliveredMessage.senderId());
        final Participant recipient =
            messageDeliveryArchive
            .participantWithId(undeliveredMessage.receiverId());
        final Message message = Message.withIdFromSenderToReceiverWithContent(
            UUID.randomUUID(),
            sender,
            recipient,
            undeliveredMessage.content());
        conversation.includeMessage(message);
        messageDeliveryArchive.saveMessageToConversation(message, conversation);
        if (receiver != null)
        {
            receiver.receiveMessage(new DeliveredMessage(
                conversation.id(),
                sender.id(),
                recipient.id(),
                message.content()));
        }
    }
}
