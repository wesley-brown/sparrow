package com.allegory.sparrow.app.messaging.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends
    JpaRepository<PersistedMessage, Long>
{
}
