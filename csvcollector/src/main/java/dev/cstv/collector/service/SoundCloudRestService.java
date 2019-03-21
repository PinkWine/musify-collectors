package dev.cstv.collector.service;

import java.util.List;

import dev.cstv.musify.domain.SongMessage;
import dev.cstv.musify.domain.SoundCloudSongJson;
import dev.cstv.musify.domain.SoundCloudSongs;

public interface SoundCloudRestService {
	
	List<SongMessage> read() ;
	
	void create(SongMessage song);

}
