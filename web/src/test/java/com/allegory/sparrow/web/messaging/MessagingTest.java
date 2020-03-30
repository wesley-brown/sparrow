package com.allegory.sparrow.web.messaging;

import static org.assertj.core.api.Assertions.assertThat;
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
    private List<ConversationResponse> initialConversations;
    private ConversationsService conversationsService;
    private ConversationsController conversationsController;

    @BeforeEach
    void setUp() {
        namesOfParticipants = new ArrayList<>();
        addParticipants();
        paulAndBobsMessages = new ArrayList<>();
        paulAndBobsConversation = new ConversationResponse(
            1, namesOfParticipants, paulAndBobsMessages);
        paulsMessage = new MessageResponse(
            1, "Paul", "Bob", "How can I help you?");
        initialConversations = new ArrayList<>();
        initialConversations.add(paulAndBobsConversation);
        conversationsService = new ConversationsService(initialConversations);
        conversationsController =
            new ConversationsController(conversationsService);
    }

    @AfterEach
    void tearDown() {
        namesOfParticipants = null;
        paulAndBobsMessages = null;
        paulAndBobsConversation = null;
        paulsMessage = null;
        initialConversations = null;
        conversationsService = null;
        conversationsController = null;
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
        final ConversationResponse receivedConversation =
            conversationsController.getConversationById(1);
        assertEquals(paulAndBobsConversation, receivedConversation);
    }

    @Test
    void posting_a_valid_conversation_returns_that_conversation() {
        final List<String> paulAndAlicesNames = new ArrayList<>();
        paulAndAlicesNames.add("Paul");
        paulAndAlicesNames.add("Alice");
        final ConversationRequest paulAndAlicesConversation =
            new ConversationRequest(paulAndAlicesNames);
        final ConversationResponse postedConversation =
            conversationsController.postConversation(paulAndAlicesConversation);
        assertThat(postedConversation.participantNames())
            .containsExactlyInAnyOrderElementsOf(paulAndAlicesNames);
    }

    private void addParticipants() {
        namesOfParticipants.add("Paul");
        namesOfParticipants.add("Bob");
    }

    private MessageResponse duplicatePaulsMessage() {
        return new MessageResponse(1, "Paul", "Bob", "How can I help you?");
    }
}
