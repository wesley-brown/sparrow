package com.allegory.sparrow.persistence.messaging;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends
    CrudRepository<PersistedParticipant, Long>
{
    PersistedParticipant findByParticipantId(final UUID participantId);
    PersistedParticipant findByName(final String name);
}
