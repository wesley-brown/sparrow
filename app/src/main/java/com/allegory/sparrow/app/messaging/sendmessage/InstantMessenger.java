package com.allegory.sparrow.app.messaging.sendmessage;

import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import com.allegory.sparrow.persistence.messaging.sendmessage.*;

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
        final Participant sender = new Participant(
            undeliveredMessage.senderName());
        final Participant recipient = new Participant(
            undeliveredMessage.receiverName());
        final Message message = new Message(
            sender,
            recipient,
            undeliveredMessage.content());
        final Message includedMessage = conversation.includeMessage(message);
        final PersistedParticipant persistedSender =
            participantRepository
            .findByName(sender.name());
        final PersistedParticipant persistedReceiver =
            participantRepository
            .findByName(recipient.name());
        final PersistedMessage persistedMessage = new PersistedMessage(
            persistedSender,
            persistedReceiver,
            includedMessage.content());
        persistedConversation.getMessages().add(persistedMessage);
        messageRepository.save(persistedMessage);
        conversationRepository.save(persistedConversation);
        final DeliveredMessage deliveredMessage = new DeliveredMessage(
            persistedConversation.getId(),
            sender.name(),
            recipient.name(),
            message.content());
        if (receiver != null)
        {
            receiver.receiveMessage(deliveredMessage);
        }
    }
}
