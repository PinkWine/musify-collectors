package dev.cstv.collector.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.cstv.collector.rest.RestHttpHeader;
import dev.cstv.collector.rest.SoundCloudRestHttpHeader;
import dev.cstv.collector.service.SoundCloudRestService;
import dev.cstv.musify.domain.SongMessage;
import dev.cstv.musify.domain.SoundCloudSongJson;
import dev.cstv.musify.domain.SoundCloudSongs;

@Component
public class SoundCloudRestServiceImpl implements SoundCloudRestService {

	private static String BASE_URL = "https://api-v2.soundcloud.com/featured_tracks/front?client_id=ccneGvN2nRqzObcQIySRAOqGH61n58zg&limit=20&offset=0&linked_partitioning=1&app_version=1552999161&app_locale=en";

	String baseUrl = BASE_URL;
	String baseUrlExtended = baseUrl + "/";

	@Autowired
	SoundCloudRestHttpHeader soundCloudRestHttpHeader;
	 
	public SoundCloudSongs retrieveAll() {
		RestTemplate restTemplate = soundCloudRestHttpHeader.getRestTemplate();
		
		return (restTemplate
				.exchange(baseUrlExtended, HttpMethod.GET, soundCloudRestHttpHeader.getHttpEntity(), SoundCloudSongs.class)
				.getBody());
		// Returns Song in Body HTTP Message
	}

	public void create(SongMessage song) {
		// TODO call webservice
		System.out.println("calling REST: " + song.getTitle());
		
		RestTemplate restTemplate = soundCloudRestHttpHeader.getRestTemplate();
		// HTTPEntity - SEND Headers & Body
		HttpEntity<SongMessage> httpEntity = new HttpEntity<SongMessage>(song, soundCloudRestHttpHeader.getHttpHeaders());
		restTemplate.postForObject(baseUrl, httpEntity, SongMessage.class);
	}

	public List<SongMessage> read() {
		List<SoundCloudSongJson> collection = retrieveAll().getCollection().subList(0, 10);
		List<SongMessage> result = new ArrayList<>();
		// take a part of data from soundcloud 
		for (SoundCloudSongJson json : collection) {
			SongMessage songMessage = new SongMessage();
			songMessage.setUrl(json.getPermalink_url());
			songMessage.setTitle(json.getTitle());
			songMessage.setDuration(json.getDuration());
			result.add(songMessage);
		}
		return result;
	}
}
