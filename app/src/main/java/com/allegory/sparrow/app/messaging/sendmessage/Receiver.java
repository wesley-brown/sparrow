package com.allegory.sparrow.app.messaging.sendmessage;

/**
 * A receiver of a message.
 */
public interface Receiver
{
    /**
     * Receive a delivered message from a sender.
     *
     * @param deliveredMessage the delivered message to receive.
     */
    void receiveMessage(DeliveredMessage deliveredMessage);
}
