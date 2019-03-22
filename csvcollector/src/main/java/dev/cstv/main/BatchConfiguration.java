package dev.cstv.main;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

@Configuration
@EnableBatchProcessing(modular = false)
@EnableScheduling
public class BatchConfiguration {
	
	@Bean
	public TaskScheduler taskScheduler() {
	    return new ConcurrentTaskScheduler(); //single threaded by default
	}
}
