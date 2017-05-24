package com.outlook.dev.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingTimeSuggestion {

	@JsonProperty("Confidence")
	private String confidence;

	@JsonProperty("OrganizerAvailability")
	private String organizerAvailability;

	@JsonProperty("MeetingTimeSlot")
	private MeetingTimeSlot meetingTimeSlot;

	@JsonProperty("AttendeeAvailability")
	private List<AttendeeAvailability> attendeeAvailabilityList;

	@JsonProperty("Locations")
	private List<Location> locations;

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

	public String getOrganizerAvailability() {
		return organizerAvailability;
	}

	public void setOrganizerAvailability(String organizerAvailability) {
		this.organizerAvailability = organizerAvailability;
	}

	public MeetingTimeSlot getMeetingTimeSlot() {
		return meetingTimeSlot;
	}

	public void setMeetingTimeSlot(MeetingTimeSlot meetingTimeSlot) {
		this.meetingTimeSlot = meetingTimeSlot;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<AttendeeAvailability> getAttendeeAvailabilityList() {
		return attendeeAvailabilityList;
	}

	public void setAttendeeAvailabilityList(List<AttendeeAvailability> attendeeAvailabilityList) {
		this.attendeeAvailabilityList = attendeeAvailabilityList;
	}
}
