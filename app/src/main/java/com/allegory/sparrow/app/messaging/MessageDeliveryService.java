package com.allegory.sparrow.app.messaging;

import com.allegory.sparrow.domain.messaging.DeliveredMessage;
import com.allegory.sparrow.domain.messaging.Participant;
import com.allegory.sparrow.domain.messaging.UndeliveredMessage;

/**
 * Delivers undelivered messages.
 */
public final class MessageDeliveryService {

    /**
     * Deliver an undelivered message to its receiver.
     *
     * @param undeliveredMessage the undelivered message to deliver.
     * @param receiver the receiver of the undelivered message.
     * @return the delivered message.
     */
    DeliveredMessage deliverMessageTo(
        final UndeliveredMessage undeliveredMessage,
        final Participant receiver) {
        return undeliveredMessage.sendTo(receiver);
    }
}
