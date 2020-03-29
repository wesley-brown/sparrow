package com.allegory.sparrow.web.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MessagingTest {
    private List<String> namesOfParticipants;
    private List<Message> paulAndBobsMessages;
    private ConversationResponse paulAndBobsConversation;
    private Message paulsMessage;

    @BeforeEach
    void setUp() {
        namesOfParticipants = new ArrayList<>();
        addParticipants();
        paulAndBobsMessages = new ArrayList<>();
        paulAndBobsConversation = new ConversationResponse(
            1, namesOfParticipants, paulAndBobsMessages);
        paulsMessage = new Message(
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
        final Message paulsDuplicateMessage = duplicatePaulsMessage();
        assertEquals(paulsMessage.hashCode(), paulsDuplicateMessage.hashCode());
    }

    @Test
    void identical_messages_are_equal() {
        final Message paulsDuplicateMessage = duplicatePaulsMessage();
        assertEquals(paulsMessage, paulsDuplicateMessage);
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

    private void addParticipants() {
        namesOfParticipants.add("Paul");
        namesOfParticipants.add("Bob");
    }

    private Message duplicatePaulsMessage() {
        return new Message("Paul", "Bob", "How can I help you?");
    }
}
