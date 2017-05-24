package com.outlook.dev.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttendeeAvailability {

	@JsonProperty("Availability")
	private String availability;

	@JsonProperty("Attendee")
	private Attendees attendees;

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Attendees getAttendees() {
		return attendees;
	}

	public void setAttendees(Attendees attendees) {
		this.attendees = attendees;
	}
}
