package com.outlook.dev.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FindMeetingRequest {

	@JsonProperty("Attendees")
	private List<Attendees> attendeesList;

	@JsonProperty("TimeConstraint")
	private TimeConstraint timeConstraint;

	@JsonProperty("MeetingDuration")
	private String meetingDuration;

	@JsonProperty("ReturnSuggestionReasons")
	private Boolean returnSuggestionReasons;

	public List<Attendees> getAttendeesList() {
		return attendeesList;
	}

	public void setAttendeesList(List<Attendees> attendeesList) {
		this.attendeesList = attendeesList;
	}

	public TimeConstraint getTimeConstraint() {
		return timeConstraint;
	}

	public void setTimeConstraint(TimeConstraint timeConstraint) {
		this.timeConstraint = timeConstraint;
	}

	public String getMeetingDuration() {
		return meetingDuration;
	}

	public void setMeetingDuration(String meetingDuration) {
		this.meetingDuration = meetingDuration;
	}

	public Boolean getReturnSuggestionReasons() {
		return returnSuggestionReasons;
	}

	public void setReturnSuggestionReasons(Boolean returnSuggestionReasons) {
		this.returnSuggestionReasons = returnSuggestionReasons;
	}
}
