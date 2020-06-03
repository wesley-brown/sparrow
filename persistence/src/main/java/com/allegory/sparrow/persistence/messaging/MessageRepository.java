package com.allegory.sparrow.persistence.messaging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends
    JpaRepository<PersistedMessage, Long>
{
}
