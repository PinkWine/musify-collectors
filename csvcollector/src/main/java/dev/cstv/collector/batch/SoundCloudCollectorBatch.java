package dev.cstv.collector.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import dev.cstv.collector.service.SoundCloudRestService;
import dev.cstv.collector.service.SoundCloudWriterService;
import dev.cstv.musify.domain.SongMessage;

@Component
public class SoundCloudCollectorBatch {

	@Autowired
	SoundCloudRestService soundCloudRestService;
	
	@Autowired
	SoundCloudWriterService soundCloudWriterService;
	
	// 2am everyday
	@Scheduled(cron = "0 0 2 * * *")
	public void startjob() throws  Exception {
		
		System.out.println("===== Getting data from SoundCloud ===== " );

	 	// read part data from sound cloud
	 	List<SongMessage> collection = soundCloudRestService.read();
	 	soundCloudWriterService.write(collection );
	}
}
