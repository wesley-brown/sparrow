package com.allegory.sparrow.app.messaging.sendmessage;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import com.allegory.sparrow.persistence.messaging.sendmessage.*;
import java.util.UUID;

/**
 * Delivers messages.
 */
public final class InstantMessenger implements Sender
{
    private final Receiver receiver;
    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;
    private final ParticipantRepository participantRepository;

    public InstantMessenger(
        final Receiver receiver,
        final ConversationRepository conversationRepository,
        final MessageRepository messageRepository,
        final ParticipantRepository participantRepository)
    {
        this.receiver = receiver;
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public void deliverMessage(UndeliveredMessage undeliveredMessage)
    {
        final PersistedConversation persistedConversation =
            conversationRepository
            .findById(undeliveredMessage
            .conversationId())
            .get();
        final Conversation conversation =
            conversationRepository
            .findById(undeliveredMessage.conversationId())
            .get()
            .conversation();
        final Participant sender =
            participantRepository
            .findByParticipantId(undeliveredMessage.senderId())
            .participant();
        final Participant recipient =
            participantRepository
            .findByParticipantId(undeliveredMessage.receiverId())
            .participant();
        final Message message = Message.withIdFromSenderToReceiverWithContent(
            UUID.randomUUID(),
            sender,
            recipient,
            undeliveredMessage.content());
        final Message includedMessage = conversation.includeMessage(message);
        final PersistedParticipant persistedSender =
            participantRepository
            .findByParticipantId(sender.id());
        final PersistedParticipant persistedReceiver =
            participantRepository
            .findByParticipantId(recipient.id());
        final PersistedMessage persistedMessage = new PersistedMessage(
            message.id(),
            persistedSender,
            persistedReceiver,
            includedMessage.content());
        persistedConversation.getMessages().add(persistedMessage);
        messageRepository.save(persistedMessage);
        conversationRepository.save(persistedConversation);
        final DeliveredMessage deliveredMessage = new DeliveredMessage(
            persistedConversation.getId(),
            sender.id(),
            recipient.id(),
            message.content());
        if (receiver != null)
        {
            receiver.receiveMessage(deliveredMessage);
        }
    }
}
