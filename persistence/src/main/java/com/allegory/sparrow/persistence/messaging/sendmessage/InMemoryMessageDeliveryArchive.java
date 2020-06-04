package com.allegory.sparrow.persistence.messaging.sendmessage;

import com.allegory.sparrow.app.messaging.sendmessage.MessageDeliveryArchive;
import com.allegory.sparrow.domain.messaging.Conversation;
import com.allegory.sparrow.domain.messaging.Message;
import com.allegory.sparrow.domain.messaging.Participant;
import com.allegory.sparrow.persistence.messaging.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;

/**
 * An in-memory archive of message deliveries.
 */
public final class InMemoryMessageDeliveryArchive implements
    MessageDeliveryArchive
{
    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;
    private final ParticipantRepository participantRepository;

    /**
     * Create a new in-memory message delivery archive using the given
     * conversation, message, and participant repositories.
     *
     * @param conversationRepository the repository of conversations.
     * @param messageRepository the repository of messages.
     * @param participantRepository the repository of participants.
     */
    @Autowired
    public InMemoryMessageDeliveryArchive(
        final ConversationRepository conversationRepository,
        final MessageRepository messageRepository,
        final ParticipantRepository participantRepository)
    {
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public Conversation conversationWithId(final UUID id)
    {
        return conversationRepository.findByConversationId(id).conversation();
    }

    @Override
    public Participant participantWithId(final UUID id)
    {
        return participantRepository.findByParticipantId(id).participant();
    }

    @Override
    public void saveMessageToConversation(
        final Message message,
        final Conversation conversation)
    {
        final PersistedParticipant sender =
            participantRepository
            .findByParticipantId(message.sender().id());
        final PersistedMessage persistedMessage = new PersistedMessage(
            message.id(),
            sender,
            message.content());
        messageRepository.save(persistedMessage);
        final PersistedConversation persistedConversation =
            conversationRepository
            .findByConversationId(conversation.id());
        persistedConversation.getMessages().add(persistedMessage);
        conversationRepository.save(persistedConversation);
    }
}
