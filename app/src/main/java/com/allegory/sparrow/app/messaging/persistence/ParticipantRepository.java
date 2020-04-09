package com.allegory.sparrow.app.messaging.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends
    CrudRepository<ParticipantEntity, Long> {
    ParticipantEntity findByName(final String name);
}
