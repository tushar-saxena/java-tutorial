package com.outlook.dev.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FindMeetingResponse {

	@JsonProperty("MeetingTimeSuggestions")
	private List<MeetingTimeSuggestion> meetingTimeSuggestionList;

	@JsonProperty("EmptySuggestionsReason")
	private String emptySuggestionsReason;

	public List<MeetingTimeSuggestion> getMeetingTimeSuggestionList() {
		return meetingTimeSuggestionList;
	}

	public void setMeetingTimeSuggestionList(List<MeetingTimeSuggestion> meetingTimeSuggestionList) {
		this.meetingTimeSuggestionList = meetingTimeSuggestionList;
	}

	public String getEmptySuggestionsReason() {
		return emptySuggestionsReason;
	}

	public void setEmptySuggestionsReason(String emptySuggestionsReason) {
		this.emptySuggestionsReason = emptySuggestionsReason;
	}

}
