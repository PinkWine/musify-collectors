package dev.cstv.collector.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.cstv.amqp.SongAmqpService;
import dev.cstv.collector.service.SoundCloudWriterService;
import dev.cstv.musify.domain.SongMessage;

@Component
public class SoundCloudWriterServiceImpl implements SoundCloudWriterService {

	@Autowired
	private SongAmqpService songAmqpService;

	@Override
	public void write(List<? extends SongMessage> songs) throws Exception {

		System.out.println("call SoundCloudWriterServiceImpl ......SoundCloudWrite");
		
		for (SongMessage song : songs) {
			songAmqpService.create(song);
		}
	}

}
