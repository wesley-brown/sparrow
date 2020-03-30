package com.allegory.sparrow.web.messaging;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Resolves dependencies for conversations services.
 */
@Configuration
class ConversationsServiceConfig {

    @Bean
    ConversationsService getConversationsService() {
        return new ConversationsService(conversations());
    }

    @Bean
    List<ConversationResponse> conversations() {
        final List<String> participantNames = new ArrayList<>();
        participantNames.add("Paul");
        participantNames.add("Bob");
        final List<MessageResponse> messages = new ArrayList<>();
        messages.add(new MessageResponse(
            1, "Paul", "Bob", "How can I help you?"));
        messages.add(new MessageResponse(
            1, "Bob", "Paul", "I'm looking to buy a new house."));
        final List<ConversationResponse> conversations = new ArrayList<>();
        conversations.add(new ConversationResponse(1, participantNames, messages));
        return conversations;
    }
}
