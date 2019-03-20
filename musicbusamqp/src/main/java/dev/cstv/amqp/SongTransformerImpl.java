package dev.cstv.amqp;

import org.springframework.integration.annotation.Transformer;

import dev.cstv.musify.domain.Song;

public class SongTransformerImpl implements SongTransformer {

	/**
     * Transform data
     */
	@Transformer(inputChannel="fromAmqpSongCollectorChannel", outputChannel="processSong")
	public Song transform(Song item) {
		
		// call REST to map data
		System.out.println("SongTransformerImpl call REST to map data ----");
		System.out.println(item.getTitle() + " " + item.getUrl());
		
		return item;
	}

}
