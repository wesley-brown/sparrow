package com.allegory.sparrow.web.messaging;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

final class MessagingTest {

    @Test
    void identical_messages_have_the_same_hash_codes() {
        final Message paulsMessage = new Message(
            "Paul", "Bob", "How can I help you?");
        final Message paulsDuplicateMessage = new Message(
            "Paul", "Bob", "How can I help you?");
        assertEquals(paulsMessage.hashCode(), paulsDuplicateMessage.hashCode());
    }
}
