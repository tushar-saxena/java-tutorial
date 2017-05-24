package com.outlook.dev.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeetingTimeSlot {

	@JsonProperty("Start")
	private TimeSlot start;

	@JsonProperty("End")
	private TimeSlot end;

	public TimeSlot getStart() {
		return start;
	}

	public void setStart(TimeSlot start) {
		this.start = start;
	}

	public TimeSlot getEnd() {
		return end;
	}

	public void setEnd(TimeSlot end) {
		this.end = end;
	}

	public MeetingTimeSlot(TimeSlot start, TimeSlot end) {
		this.start = start;
		this.end = end;
	}

	public MeetingTimeSlot() {
	}
}
