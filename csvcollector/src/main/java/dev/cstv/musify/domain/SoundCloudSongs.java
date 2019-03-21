package dev.cstv.musify.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SoundCloudSongs implements Serializable {

	private List<SoundCloudSongJson> collection;

	public List<SoundCloudSongJson> getCollection() {
		return collection;
	}

	public void setCollection(List<SoundCloudSongJson> collection) {
		this.collection = collection;
	}
	
	
}
