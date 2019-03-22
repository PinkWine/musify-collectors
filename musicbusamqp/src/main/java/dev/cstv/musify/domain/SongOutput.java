package dev.cstv.musify.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import dev.cstv.musify.utils.StringUtils;

public class SongOutput implements Serializable {

	private SongMessage item;

	private Date releaseDate;

	public SongOutput(SongMessage item) {
		this.item = item;

		// year - YYYY from .csv file to Date
		if (StringUtils.isNumeric(item.getYear())) {
			// get the first date of year
			Calendar cal = Calendar.getInstance();
			cal.set(Integer.parseInt(item.getYear()), 0, 1); // 0: January
			this.releaseDate = cal.getTime();
		} else {
			// set a default date for released date -> admin can filter & update this information
			Calendar cal = Calendar.getInstance();
			cal.set(1000, 0, 1);
			this.releaseDate = cal.getTime();
		}
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public SongMessage getItem() {
		return item;
	}

	public void setItem(SongMessage item) {
		this.item = item;
	}

}
