package com.allegory.sparrow.web.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MessagingTest {
    private List<String> namesOfParticipants;
    private List<MessageResponse> paulAndBobsMessages;
    private ConversationResponse paulAndBobsConversation;
    private MessageResponse paulsMessage;

    @BeforeEach
    void setUp() {
        namesOfParticipants = new ArrayList<>();
        addParticipants();
        paulAndBobsMessages = new ArrayList<>();
        paulAndBobsConversation = new ConversationResponse(
            1, namesOfParticipants, paulAndBobsMessages);
        paulsMessage = new MessageResponse(
            "Paul", "Bob", "How can I help you?");
    }

    @AfterEach
    void tearDown() {
        namesOfParticipants = null;
        paulAndBobsMessages = null;
        paulAndBobsConversation = null;
        paulsMessage = null;
    }

    @Test
    void identical_messages_have_the_same_hash_codes() {
        final MessageResponse paulsDuplicateMessageResponse = duplicatePaulsMessage();
        assertEquals(paulsMessage.hashCode(), paulsDuplicateMessageResponse.hashCode());
    }

    @Test
    void identical_messages_are_equal() {
        final MessageResponse paulsDuplicateMessageResponse = duplicatePaulsMessage();
        assertEquals(paulsMessage, paulsDuplicateMessageResponse);
    }

    @Test
    void identical_conversation_responses_have_the_same_hash_codes() {
        final ConversationResponse paulAndBobsDuplicateConversation =
            new ConversationResponse(1, namesOfParticipants, paulAndBobsMessages);
        assertEquals(paulAndBobsConversation.hashCode(),
            paulAndBobsDuplicateConversation.hashCode());
    }

    @Test
    void identical_conversation_responses_are_equal() {
        final ConversationResponse paulAndBobsDuplicateConversation =
            new ConversationResponse(1, namesOfParticipants, paulAndBobsMessages);
        assertEquals(paulAndBobsConversation, paulAndBobsDuplicateConversation);
    }

    @Test
    void getting_a_conversation_by_a_valid_id_returns_that_conversation() {
        final List<ConversationResponse> conversations = new ArrayList<>();
        conversations.add(paulAndBobsConversation);
        final ConversationsService conversationsService = new ConversationsService(conversations);
        final ConversationsController conversationsController =
            new ConversationsController(conversationsService);
        final ConversationResponse receivedConversation =
            conversationsController.getConversationById(1);
        assertEquals(paulAndBobsConversation, receivedConversation);
    }

    private void addParticipants() {
        namesOfParticipants.add("Paul");
        namesOfParticipants.add("Bob");
    }

    private MessageResponse duplicatePaulsMessage() {
        return new MessageResponse("Paul", "Bob", "How can I help you?");
    }
}
