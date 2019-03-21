package dev.cstv.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import dev.cstv.collector.batch.CSVCollectorBatch;
import dev.cstv.collector.service.SongRestService;
import dev.cstv.collector.service.SoundCloudRestService;
import dev.cstv.collector.service.SoundCloudWriterService;
import dev.cstv.collector.service.impl.SongRestServiceImpl;
import dev.cstv.musify.domain.SongMessage;
import dev.cstv.musify.domain.SoundCloudSongJson;
import dev.cstv.musify.domain.SoundCloudSongs;

@Component
public class SoundCloudMain {

	@Autowired
	CSVCollectorBatch cSVCollectorBatch;

	public static void main(String[] args) throws Throwable {

		ApplicationContext context = new ClassPathXmlApplicationContext("context/applicationContext.xml",
				"context/batch-config.xml", "context/collector-job.xml", "META-INF/spring/song-app-context.xml");
		
		context.getBean(SoundCloudMain.class).mainInternal(context);
	}

	private void mainInternal(ApplicationContext applicationContext) throws Exception {

		System.out.println("===== Getting data from SoundCloud ===== " );

	 	SoundCloudRestService  soundCloudRestService = applicationContext.getBean(SoundCloudRestService.class);
	 	// read part data from sound cloud
	 	List<SongMessage> collection = soundCloudRestService.read();
	 	SoundCloudWriterService soundCloudWriterService = applicationContext.getBean(SoundCloudWriterService.class);
	 	soundCloudWriterService.write(collection );
	}
}