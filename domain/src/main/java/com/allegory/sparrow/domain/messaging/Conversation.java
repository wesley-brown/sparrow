package com.allegory.sparrow.domain.messaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A conversation between participants.
 */
public final class Conversation
{
    private final List<Participant> participants;
    private final List<Message> messages;

    /**
     * Create a new conversation between the given participants that includes
     * the given already existing messages.
     *
     * @param participants the participants the new conversation will be
     *                     between.
     * @param messages the already existing messages that the new conversation
     *                 will include.
     * @return
     */
    public static Conversation betweenParticipantsWithMessages(
        final List<Participant> participants,
        final List<Message> messages)
    {
        return new Conversation(participants, messages);
    }

    public static Conversation betweenParticipants(
        final List<Participant> participants)
    {
        return new Conversation(participants, Collections.emptyList());
    }

    /**
     * Create a new conversation.
     *
     * @param participants the participants of the new conversation.
     */
    private Conversation(
        final List<Participant> participants,
        final List<Message> messages)
    {
        this.participants = new ArrayList<>(participants);
        this.messages = new ArrayList<>(messages);
    }

    public List<Participant> participants()
    {
        return new ArrayList<>(participants);
    }

    public List<Message> messages()
    {
        return new ArrayList<>(messages);
    }

    /**
     * Include a given message in this conversation.
     *
     * @param message the message to include.
     * @return the included message.
     */
    public Message includeMessage(final Message message)
    {
        messages.add(message);
        return message;
    }
}
