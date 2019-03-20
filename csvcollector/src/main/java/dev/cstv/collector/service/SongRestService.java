package dev.cstv.collector.service;

import dev.cstv.musify.domain.SongMessage;

public interface SongRestService {
	
	SongMessage read(Integer index);
	
	void create(SongMessage song);

}
