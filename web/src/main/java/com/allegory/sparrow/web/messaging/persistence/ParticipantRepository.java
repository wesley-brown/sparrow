package com.allegory.sparrow.web.messaging.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends
        CrudRepository<ParticipantEntity, Long> {
    ParticipantEntity findByName(final String name);
}
