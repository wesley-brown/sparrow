package com.allegory.sparrow.persistence.messaging.sendmessage;

import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversationRepository extends
    PagingAndSortingRepository<PersistedConversation, Long>
{
    PersistedConversation findByConversationId(final UUID conversationId);
}
