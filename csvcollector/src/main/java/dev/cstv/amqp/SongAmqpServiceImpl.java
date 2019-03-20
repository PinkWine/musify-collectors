package dev.cstv.amqp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.cstv.musify.domain.Song;

@Component
public class SongAmqpServiceImpl implements SongAmqpService {

	@Autowired
	RabbitTemplate directTemplate;

	@Override
	public void create(Song song) {

		System.out.println("Pushing Data To ========= Queue =========== ");
		directTemplate.convertAndSend(song);
	}

}
