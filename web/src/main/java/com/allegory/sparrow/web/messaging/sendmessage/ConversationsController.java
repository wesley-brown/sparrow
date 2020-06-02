package com.allegory.sparrow.web.messaging.sendmessage;

import com.allegory.sparrow.app.messaging.sendmessage.Sender;
import com.allegory.sparrow.app.messaging.sendmessage.UndeliveredMessage;
import com.allegory.sparrow.persistence.messaging.sendmessage.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A REST controller for conversation endpoints.
 *
 * Dependency injection will give a ConversationsController the MessageDelivery
 * interactor that it requires.
 */
@RestController
final class ConversationsController
{
    private final Sender sender;
    private final ConversationRepository conversationRepository;
    private final ParticipantRepository participantRepository;
    private final MessageRepository messageRepository;

    /**
     * Create a new conversations controller.
     */
    @Autowired
    ConversationsController(
        final Sender sender,
        final ConversationRepository conversationRepository,
        final ParticipantRepository participantRepository,
        final MessageRepository messageRepository)
    {
        this.sender = sender;
        this.conversationRepository = conversationRepository;
        this.participantRepository = participantRepository;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/api/v1/conversations")
    Iterable<PersistedConversation> getAllConversations()
    {
        return conversationRepository.findAll();
    }

    /**
     * Get a conversation by a given ID.
     *
     * @param id the unique ID of the conversation.
     * @return the conversation with the given ID.
     */
    @GetMapping("/api/v1/conversations/{id}")
    PersistedConversation getConversationById(@PathVariable final long id)
    {
        return conversationRepository.findById(id).get();
    }

    /**
     * Post a new conversation.
     *
     * @param conversation the conversation to post.
     * @return the posted conversation.
     */
    @PostMapping("/api/v1/conversations")
    PersistedConversation postConversation(
        @RequestBody final ConversationRequest conversation)
    {
        final List<PersistedParticipant> participantEntities = new ArrayList<>();
        for (final String participantName : conversation.participantNames()) {
            if (participantRepository.findByName(participantName) == null) {
                final PersistedParticipant persistedParticipant = new PersistedParticipant(UUID.randomUUID(), participantName);
                participantRepository.save(persistedParticipant);
                participantEntities.add(persistedParticipant);
            } else {
                participantEntities.add(participantRepository.findByName(participantName));
            }
        }
        final List<PersistedMessage> messageEntities = new ArrayList<>();
        final PersistedConversation persistedConversation =
            new PersistedConversation(
                UUID.randomUUID(),
                participantEntities,
                messageEntities);
        return conversationRepository.save(persistedConversation);
    }

    @PostMapping("/api/v1/conversations/{conversationId}/messages")
    PersistedMessage postMessage(
        @PathVariable final UUID conversationId,
        @RequestBody final SendMessageRequest sendMessageRequest)
    {
        final UndeliveredMessage undeliveredMessage = new UndeliveredMessage(
            conversationId,
            sendMessageRequest.senderId(),
            sendMessageRequest.receiverId(),
            sendMessageRequest.content());
        sender.deliverMessage(undeliveredMessage);
        return null;
    }
}
