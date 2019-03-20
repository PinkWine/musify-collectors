package dev.cstv.collector.batch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component(value = "moveFileToArchive")
public class MoveFileToArchive implements Tasklet  {
	
	private String PATH = "./src/main/resources/data/";
	private Resource resource;
	private String filePath = "data/";
	private String archive = PATH + "data/archive/";

	@Override
	public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
		System.out.println("moving file ....");
		final File directory = readFileFromResourcesAsString("/song.csv");
 
 		directory.renameTo(new File(archive + "/song.csv"));
		System.out.println(directory.getAbsolutePath());
		
		return RepeatStatus.FINISHED;

	}
	
	private File readFileFromResourcesAsString(String fileName) throws IOException {
	    Path filePath = Paths.get(PATH + fileName);
	    return filePath.toFile();        
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
}
