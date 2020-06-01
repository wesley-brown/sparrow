package com.allegory.sparrow.persistence.messaging.sendmessage;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends
    PagingAndSortingRepository<PersistedConversation, Long>
{
}
