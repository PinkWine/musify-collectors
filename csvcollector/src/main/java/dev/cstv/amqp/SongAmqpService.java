package dev.cstv.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import dev.cstv.musify.domain.Song;

public interface SongAmqpService {

	void create(Song topicTemplate);
 

}
