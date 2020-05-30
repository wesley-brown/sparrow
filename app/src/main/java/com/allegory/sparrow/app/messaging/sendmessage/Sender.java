package com.allegory.sparrow.app.messaging.sendmessage;

/**
 * A sender of a message.
 */
public interface Sender
{
    /**
     * Deliver the given undelivered message to its intended recipient.
     *
     * @param undeliveredMessage the undelivered message to deliver.
     */
    void deliverMessage(UndeliveredMessage undeliveredMessage);
}
