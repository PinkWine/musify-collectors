package dev.cstv.collector.service;

import java.util.List;

import dev.cstv.musify.domain.SongMessage;

public interface SoundCloudWriterService {
	
	void write(List<? extends SongMessage> songs) throws Exception;

}
