package dev.cstv.collector.service;

import dev.cstv.musify.domain.Song;

public interface SongService {
	
	Song read(Integer index);
	
	void create(Song song);

}
