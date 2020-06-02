package com.allegory.sparrow.domain.messaging;

import java.util.UUID;

/**
 * A participant in a conversation.
 */
public final class Participant
{
    private final UUID id;
    private final String name;

    /**
     * Create a new participant with a given ID and name.
     *
     * @param id the unique identifier of the participant.
     * @param name the name of the participant.
     */
    public static Participant withIdAndName(final UUID id, final String name)
    {
        return new Participant(id, name);
    }

    private Participant(final UUID id, final String name)
    {
        this.id = id;
        this.name = name;
    }

    public UUID id()
    {
        return id;
    }

    public String name()
    {
        return name;
    }

    @Override
    public int hashCode()
    {
        // Uses the Effective Java 3 Item 11 algorithm
        int result = id.hashCode();
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
        return participant.id == this.id;
    }

    @Override
    public String toString()
    {
        return "<id=" + id() + ", name=" + name() + ">";
    }
}
