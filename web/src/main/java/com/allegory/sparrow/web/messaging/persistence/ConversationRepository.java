package com.allegory.sparrow.web.messaging.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends
        PagingAndSortingRepository<ConversationEntity, Long> {
}
