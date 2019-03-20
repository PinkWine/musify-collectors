package dev.cstv.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import dev.cstv.musify.domain.SongMessage;

public interface SongAmqpService {

	void create(SongMessage topicTemplate);
 

}
