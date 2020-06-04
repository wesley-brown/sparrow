package com.allegory.sparrow.web.messaging.sendmessage;

import com.allegory.sparrow.app.messaging.sendmessage.Sender;
import com.allegory.sparrow.app.messaging.sendmessage.UndeliveredMessage;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A REST controller for the send message endpoint.
 */
@RestController
final class MessageSendingController
{
    private final Sender sender;

    /**
     * Create a new message sending controller.
     */
    @Autowired
    MessageSendingController(final Sender sender)
    {
        this.sender = sender;
    }

    /**
     * Send the message represented by the given send message request to the
     * conversation with the given conversation ID.
     *
     * @param conversationId the ID of the conversation to send the message to.
     * @param sendMessageRequest the send message request that represents the
     *                           message to send.
     */
    @PostMapping("/api/v1/conversations/{conversationId}/messages")
    void sendMessage(
        @PathVariable final UUID conversationId,
        @RequestBody final SendMessageRequest sendMessageRequest)
    {
        final UndeliveredMessage undeliveredMessage = new UndeliveredMessage(
                conversationId,
                sendMessageRequest.senderId(),
                sendMessageRequest.content());
        sender.deliverMessage(undeliveredMessage);
    }
}
