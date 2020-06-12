package com.allegory;

import com.allegory.sparrow.app.messaging.sendmessage.InstantMessenger;
import com.allegory.sparrow.app.messaging.sendmessage.MessageDeliveryArchive;
import com.allegory.sparrow.app.messaging.sendmessage.Sender;
import com.allegory.sparrow.app.messaging.ConversationsArchive;
import com.allegory.sparrow.app.messaging.viewallconversations.AllConversationsViewer;
import com.allegory.sparrow.app.messaging.viewconversation.ConversationViewer;
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
		return new InstantMessenger(messageDeliveryArchive);
	}

	@Bean
	public ConversationViewer conversationViewer(
		final ConversationsArchive conversationsArchive)
	{
		return new ConversationViewer(conversationsArchive);
	}

	@Bean
	public AllConversationsViewer allConversationsViewer(
		final ConversationsArchive conversationsArchive)
	{
		return new AllConversationsViewer(conversationsArchive);
	}

}
