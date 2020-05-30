package com.allegory.sparrow.domain.messaging;

import java.util.UUID;

/**
 * A participant in a conversation.
 */
public final class Participant
{
    private final UUID uuid;
    private final String name;

    /**
     * Create a new participant.
     *
     * @param name the name of the participant.
     */
    public Participant(final String name)
    {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    public String name()
    {
        return name;
    }

    @Override
    public int hashCode()
    {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = uuid.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object other)
    {
        if (other == this)
        {
            return true;
        }
        if (!(other instanceof Participant))
        {
            return false;
        }
        final Participant participant = (Participant) other;
        return participant.uuid == this.uuid;
    }

    @Override
    public String toString()
    {
        return "<uuid=" + uuid + ",name=" + name + ">";
    }
}
