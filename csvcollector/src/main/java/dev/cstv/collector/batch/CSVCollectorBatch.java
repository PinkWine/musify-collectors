package dev.cstv.collector.batch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CSVCollectorBatch {

	// Configured Job
	@Autowired
	Job csvCollectorJob;
	
	@Autowired
	JobLauncher jobLauncher;
	
	// 1AM everyday
	@Scheduled(cron = "0 0 1 * * *")
	public void startjob() throws  Exception {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Starting batch " + dateFormat.format(date));  
		
 	    JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
	    jobParametersBuilder.addDate("date", new Date());
	    JobParameters jobParameters = jobParametersBuilder.toJobParameters();
	    JobExecution jobExecution = jobLauncher.run(csvCollectorJob, jobParameters);
	    BatchStatus batchStatus = jobExecution.getStatus();
	    
	    System.out.println("Exit status: " + jobExecution.getExitStatus().getExitCode());
	}
}
