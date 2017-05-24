package com.outlook.dev.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSlot {

	@JsonProperty("DateTime")
	private Date dateTime;

	@JsonProperty("TimeZone")
	private String timeZone;

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public TimeSlot(Date dateTime, String timeZone) {
		this.dateTime = dateTime;
		this.timeZone = timeZone;
	}

	public TimeSlot() {
	}
}
