package com.allegory;

import com.allegory.sparrow.app.messaging.sendmessage.InstantMessenger;
import com.allegory.sparrow.app.messaging.sendmessage.Sender;
import com.allegory.sparrow.persistence.messaging.sendmessage.ConversationRepository;
import com.allegory.sparrow.persistence.messaging.sendmessage.MessageRepository;
import com.allegory.sparrow.persistence.messaging.sendmessage.ParticipantRepository;
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
	public Sender instantMessenger(
		final ConversationRepository conversationRepository,
		final MessageRepository messageRepository,
		final ParticipantRepository participantRepository)
	{
		return new InstantMessenger(
			null,
			conversationRepository,
			messageRepository,
			participantRepository);
	}

}
