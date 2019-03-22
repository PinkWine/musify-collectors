package dev.cstv.collector.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import dev.cstv.amqp.SongAmqpService;
import dev.cstv.musify.domain.SongMessage;

/*
 * Declared in collector-job.xml
 */
public class SongItemWriter implements ItemWriter<SongMessage> {

	private SongAmqpService songAmqpService;

	public void write(List<? extends SongMessage> songs) throws Exception {

		System.out.println("call songService ......SongItemWriter");
		for (SongMessage song : songs) {
			songAmqpService.create(song);
		}
	}

	public SongAmqpService getSongAmqpService() {
		return songAmqpService;
	}

	public void setSongAmqpService(SongAmqpService songAmqpService) {
		this.songAmqpService = songAmqpService;
	}

}
