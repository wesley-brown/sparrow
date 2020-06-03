package com.allegory.sparrow.domain.messaging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * A conversation between participants.
 */
public final class Conversation
{
    private final UUID id;
    private final List<Participant> participants;
    private final List<Message> messages;

    /**
     * Create a new conversation with a given ID, between the given
     * participants, that includes the given messages.
     *
     * @param id the unique identifier of the conversation.
     * @param participants the participants of the conversation.
     * @param messages the already existing messages of the conversation.
     * @return the new conversation with the given ID, participants, and
     *         messages.
     */
    public static Conversation withIdBetweenParticipantsWithMessages(
        final UUID id,
        final List<Participant> participants,
        final List<Message> messages)
    {
        return new Conversation(id, participants, messages);
    }

    /**
     * Create a new conversation with a given ID, between the given
     * participants, with no messages.
     *
     * @param id the unique identifier of the conversation.
     * @param participants the participants of the conversation.
     * @return the new conversation with the given ID, participants, and no
     *         messages.
     */
    public static Conversation withIdBetweenParticipants(
        final UUID id,
        final List<Participant> participants)
    {
        return withIdBetweenParticipantsWithMessages(
            id,
            participants,
            Collections.emptyList());
    }

    private Conversation(
        final UUID id,
        final List<Participant> participants,
        final List<Message> messages)
    {
        this.id = id;
        this.participants = new ArrayList<>(participants);
        this.messages = new ArrayList<>(messages);
    }

    public UUID id()
    {
        return id;
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

    @Override
    public String toString()
    {
        return "<id=" + id() + ", participants=" + participants()
            + ", messages=" + messages() + ">";
    }
}
