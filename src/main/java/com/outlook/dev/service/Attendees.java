package com.outlook.dev.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attendees {
	@JsonProperty("EmailAddress")
	private EmailAddress emailAddress;

	@JsonProperty("Type")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	public  Attendees(){
	}

	public Attendees(EmailAddress emailAddress, String type) {
		this.emailAddress = emailAddress;
		this.type = type;
	}
}
