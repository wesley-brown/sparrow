package com.allegory.sparrow.persistence.messaging.sendmessage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends
    CrudRepository<PersistedParticipant, Long>
{
    PersistedParticipant findByName(final String name);
}
