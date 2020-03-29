package com.allegory.sparrow.web.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private Message duplicatePaulsMessage() {
        return new Message("Paul", "Bob", "How can I help you?");
    }
}
