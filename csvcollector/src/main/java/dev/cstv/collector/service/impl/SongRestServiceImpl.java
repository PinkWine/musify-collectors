package dev.cstv.collector.service.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.cstv.collector.rest.RestHttpHeader;
import dev.cstv.collector.service.SongRestService;
import dev.cstv.musify.domain.SongMessage;

@Component
public class SongRestServiceImpl implements SongRestService {

	private Logger LOG = Logger.getLogger(SongRestServiceImpl.class.getName());

	private static String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

	String baseUrl = "http://localhost:8080/JerseyRestSecurity/songs";
	String baseUrlExtended = baseUrl + "/";

	@Autowired
	RestHttpHeader restHttpHeader;
	 
	public SongMessage read(Integer index) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		return (restTemplate
				.exchange(baseUrlExtended + index, HttpMethod.GET, restHttpHeader.getHttpEntity(), SongMessage.class)
				.getBody());
		// Returns Song in Body HTTP Message
	}

	public void create(SongMessage song) {
		// TODO call webservice
		System.out.println("calling REST: " + song.getTitle());
		
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		// HTTPEntity - SEND Headers & Body
		HttpEntity<SongMessage> httpEntity = new HttpEntity<SongMessage>(song, restHttpHeader.getHttpHeaders());
		restTemplate.postForObject(baseUrl, httpEntity, SongMessage.class);
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri(BASE_URL).build();
	}

	public List<SongMessage> read() {

		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		return Arrays.asList(
				restTemplate.exchange(baseUrl, HttpMethod.GET, restHttpHeader.getHttpEntity(), SongMessage[].class).getBody());
		// restHttpHeader.getHttpEntity() - get HTTP headers [Authentication; JSON
		// ACCEPT]
	}

}
