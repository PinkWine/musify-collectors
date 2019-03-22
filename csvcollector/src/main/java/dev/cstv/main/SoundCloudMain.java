package dev.cstv.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import dev.cstv.collector.service.SoundCloudRestService;
import dev.cstv.collector.service.SoundCloudWriterService;
import dev.cstv.musify.domain.SongMessage;

@Component
public class SoundCloudMain {


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