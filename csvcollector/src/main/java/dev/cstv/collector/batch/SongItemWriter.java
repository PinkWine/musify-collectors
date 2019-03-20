package dev.cstv.collector.batch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import dev.cstv.amqp.SongAmqpService;
import dev.cstv.collector.service.SongRestService;
import dev.cstv.musify.domain.SongMessage;

/*
 * Declared in collector-job.xml
 */
public class SongItemWriter implements ItemWriter<SongMessage> {

	private Logger LOG = Logger.getLogger(SongItemWriter.class.getName());
	// REST
	private SongRestService songService;
	private SongAmqpService songAmqpService;

	public void write(List<? extends SongMessage> songs) throws Exception {

		System.out.println("call songService ......SongItemWriter");
		// REST
//		for (Song song : songs) {
//			songService.create(song);
//		}
		for (SongMessage song : songs) {
			songAmqpService.create(song);
		}
	}

	public SongRestService getSongService() {
		return songService;
	}

	public void setSongService(SongRestService songService) {
		this.songService = songService;
	}

	public SongAmqpService getSongAmqpService() {
		return songAmqpService;
	}

	public void setSongAmqpService(SongAmqpService songAmqpService) {
		this.songAmqpService = songAmqpService;
	}

}
