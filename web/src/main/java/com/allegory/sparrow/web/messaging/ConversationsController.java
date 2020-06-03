package com.allegory.sparrow.web.messaging;

import com.allegory.sparrow.persistence.messaging.ConversationRepository;
import com.allegory.sparrow.persistence.messaging.MessageRepository;
import com.allegory.sparrow.persistence.messaging.ParticipantRepository;
import com.allegory.sparrow.persistence.messaging.PersistedConversation;
import com.allegory.sparrow.persistence.messaging.PersistedMessage;
import com.allegory.sparrow.persistence.messaging.PersistedParticipant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A REST controller for various conversations endpoints.
 */
@RestController
final class ConversationsController {
    private final ConversationRepository conversationRepository;
    private final ParticipantRepository participantRepository;
    private final MessageRepository messageRepository;

    @Autowired
    ConversationsController(
            final ConversationRepository conversationRepository,
            final ParticipantRepository participantRepository,
            final MessageRepository messageRepository)
    {
        this.conversationRepository = conversationRepository;
        this.participantRepository = participantRepository;
        this.messageRepository = messageRepository;
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
}
