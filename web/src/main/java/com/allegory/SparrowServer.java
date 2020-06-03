package com.allegory;

import com.allegory.sparrow.app.messaging.sendmessage.InstantMessenger;
import com.allegory.sparrow.app.messaging.sendmessage.MessageDeliveryArchive;
import com.allegory.sparrow.app.messaging.sendmessage.Sender;
import com.allegory.sparrow.app.messaging.viewallconversations.AllConversationsRecord;
import com.allegory.sparrow.app.messaging.viewallconversations.ConversationsArchive;
import com.allegory.sparrow.app.messaging.viewallconversations.ConversationsRecord;
import com.allegory.sparrow.persistence.messaging.ConversationRepository;
import com.allegory.sparrow.persistence.messaging.sendmessage.InMemoryMessageDeliveryArchive;
import com.allegory.sparrow.persistence.messaging.MessageRepository;
import com.allegory.sparrow.persistence.messaging.ParticipantRepository;
import com.allegory.sparrow.persistence.messaging.viewallconversations.InMemoryConversationsArchive;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

/**
 * A Sparrow server.
 */
@SpringBootApplication
public class SparrowServer
{
	public static void main(String[] args)
	{
		SpringApplication.run(SparrowServer.class, args);
	}

	@Bean
	public ConversationsArchive conversationsArchive(
		final ConversationRepository conversationRepository)
	{
		return new InMemoryConversationsArchive(conversationRepository);
	}

	@Bean
	public ConversationsRecord conversationsRecord(
		final ConversationsArchive conversationsArchive)
	{
		return new AllConversationsRecord(conversationsArchive);
	}

	@Bean
	public MessageDeliveryArchive inMemoryMessageDeliveryArchive(
		final ConversationRepository conversationRepository,
		final MessageRepository messageRepository,
		final ParticipantRepository participantRepository)
	{
		return new InMemoryMessageDeliveryArchive(
			conversationRepository,
			messageRepository,
			participantRepository);
	}

	@Bean
	public Sender instantMessenger(
		final MessageDeliveryArchive messageDeliveryArchive)
	{
		return new InstantMessenger(
			null,
			messageDeliveryArchive);
	}

}
