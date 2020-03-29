package com.allegory.sparrow.web.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MessagingTest {
    private Message paulsMessage;

    @BeforeEach
    void setUp() {
        paulsMessage = new Message(
            "Paul", "Bob", "How can I help you?");
    }

    @AfterEach
    void tearDown() {
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
        final List<String> namesOfParticipants = new ArrayList<>();
        namesOfParticipants.add("Paul");
        namesOfParticipants.add("Bob");
        final List<Message> paulAndBobsMessages = new ArrayList<>();
        paulAndBobsMessages.add(paulsMessage);
        final ConversationResponse paulAndBobsConversationResponse =
            new ConversationResponse(1, namesOfParticipants, paulAndBobsMessages);
        final ConversationResponse paulAndBobsDuplicateConversationResponse =
            new ConversationResponse(1, namesOfParticipants, paulAndBobsMessages);
        assertEquals(paulAndBobsConversationResponse.hashCode(),
            paulAndBobsDuplicateConversationResponse.hashCode());
    }

    private Message duplicatePaulsMessage() {
        return new Message("Paul", "Bob", "How can I help you?");
    }
}
