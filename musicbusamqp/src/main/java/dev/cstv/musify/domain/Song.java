package dev.cstv.musify.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

public class Song  implements Serializable  {

	private String title;
    
    private String url;
 
    private Integer duration;
    private Date releaseDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
 
 
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
