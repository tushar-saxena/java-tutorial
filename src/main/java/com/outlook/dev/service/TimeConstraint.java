package com.outlook.dev.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeConstraint {

	@JsonProperty("ActivityDomain")
	private String activityDomain;

	@JsonProperty("Timeslots")
	private List<MeetingTimeSlot> meetingTimeSlots;

	public String getActivityDomain() {
		return activityDomain;
	}

	public void setActivityDomain(String activityDomain) {
		this.activityDomain = activityDomain;
	}

	public List<MeetingTimeSlot> getMeetingTimeSlots() {
		return meetingTimeSlots;
	}

	public void setMeetingTimeSlots(List<MeetingTimeSlot> meetingTimeSlots) {
		this.meetingTimeSlots = meetingTimeSlots;
	}

	public TimeConstraint(String activityDomain, List<MeetingTimeSlot> meetingTimeSlots) {
		this.activityDomain = activityDomain;
		this.meetingTimeSlots = meetingTimeSlots;
	}

	public TimeConstraint() {
	}
}
