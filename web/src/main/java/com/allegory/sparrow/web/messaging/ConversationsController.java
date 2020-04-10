package com.allegory.sparrow.web.messaging;

import java.util.ArrayList;
import java.util.List;

import com.allegory.sparrow.app.messaging.persistence.ParticipantEntity;
import com.allegory.sparrow.app.messaging.persistence.ParticipantRepository;
import com.allegory.sparrow.web.messaging.persistence.ConversationEntity;
import com.allegory.sparrow.web.messaging.persistence.ConversationRepository;
import com.allegory.sparrow.app.messaging.persistence.MessageEntity;
import com.allegory.sparrow.app.messaging.persistence.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * A REST controller for conversation endpoints.
 */
@RestController
final class ConversationsController {
    private final ParticipantRepository participantRepository;
    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;

    /**
     * Create a new conversations controller.
     */
    @Autowired
    ConversationsController(final ParticipantRepository participantRepository,
                            final ConversationRepository conversationRepository,
                            final MessageRepository messageRepository) {
        this.participantRepository = participantRepository;
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
    }

    @GetMapping("/api/v1/conversations")
    Iterable<ConversationEntity> getAllConversations() {
        return conversationRepository.findAll();
    }

    /**
     * Get a conversation by a given ID.
     *
     * @param id the unique ID of the conversation.
     * @return the conversation with the given ID.
     */
    @GetMapping("/api/v1/conversations/{id}")
    ConversationEntity getConversationById(@PathVariable final long id) {
        return conversationRepository.findById(id).get();
    }

    /**
     * Post a new conversation.
     *
     * @param conversation the conversation to post.
     * @return the posted conversation.
     */
    @PostMapping("/api/v1/conversations")
    ConversationEntity postConversation(
        @RequestBody final ConversationRequest conversation) {
        final List<ParticipantEntity> participantEntities = new ArrayList<>();
        for (final String participantName : conversation.participantNames()) {
            if (participantRepository.findByName(participantName) == null) {
                final ParticipantEntity participantEntity = new ParticipantEntity(participantName);
                participantRepository.save(participantEntity);
                participantEntities.add(participantEntity);
            } else {
                participantEntities.add(participantRepository.findByName(participantName));
            }
        }
        final List<MessageEntity> messageEntities = new ArrayList<>();
        final ConversationEntity conversationEntity = new ConversationEntity(participantEntities, messageEntities);
        return conversationRepository.save(conversationEntity);
    }

    @PostMapping("/api/v1/conversations/{conversationId}/messages")
    MessageEntity postMessage(@PathVariable final Long conversationId,
                              @RequestBody final MessageRequest message) {
        final ParticipantEntity sender =
            participantRepository.findByName(message.senderName());
        final ParticipantEntity receiver =
            participantRepository.findByName(message.receiverName());
        final MessageEntity messageEntity =
            new MessageEntity(sender, receiver, message.content());
        final ConversationEntity conversationEntity =
            conversationRepository.findById(conversationId).get();
        conversationEntity.getMessages().add(messageEntity);
        messageRepository.save(messageEntity);
        conversationRepository.save(conversationEntity);
        return messageEntity;
    }
}
