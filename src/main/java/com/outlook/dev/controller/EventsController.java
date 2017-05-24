package com.outlook.dev.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.outlook.dev.service.*;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.outlook.dev.auth.TokenResponse;

@Controller
public class EventsController {

	@RequestMapping("/events")
	public String events(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession();
		TokenResponse tokens = (TokenResponse)session.getAttribute("tokens");
		if (tokens == null) {
			// No tokens in session, user needs to sign in
			redirectAttributes.addFlashAttribute("error", "Please sign in to continue.");
			return "redirect:/index.html";
		}
		
		Date now = new Date();
		if (now.after(tokens.getExpirationTime())) {
			// Token expired
			// TODO: Use the refresh token to request a new token from the token endpoint
			// For now, just complain
			redirectAttributes.addFlashAttribute("error", "The access token has expired. Please logout and re-login.");
			return "redirect:/index.html";
		}
		
		String email = (String)session.getAttribute("userEmail");
		
		OutlookService outlookService = OutlookServiceBuilder.getOutlookService(tokens.getAccessToken(), email);
		
		// Sort by start time in descending order
		String sort = "Start/DateTime DESC";
		// Only return the properties we care about
		String properties = "Organizer,Subject,Start,End";
		// Return at most 10 events
		Integer maxResults = 10;
		
		try {
			PagedResult<Event> events = outlookService.getEvents(
					sort, properties, maxResults)
					.execute().body();
			model.addAttribute("events", events.getValue());
		} catch (IOException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/index.html";
		}
		
		return "events";
	}

	@RequestMapping("/findMeetingTimes")
	public String findMeetingTimes(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		return "findMeetingTimes";
	}

	@RequestMapping("/searchMeetingTimes")
	public String searchMeetingTimes(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) throws IOException {
		HttpSession session = request.getSession();
		TokenResponse tokens = (TokenResponse) session.getAttribute("tokens");
		if (tokens == null) {
			// No tokens in session, user needs to sign in
			redirectAttributes.addFlashAttribute("error", "Please sign in to continue.");
			return "redirect:/index.html";
		}

		Date now = new Date();
		if (now.after(tokens.getExpirationTime())) {
			// Token expired
			// TODO: Use the refresh token to request a new token from the token endpoint
			// For now, just complain
			redirectAttributes.addFlashAttribute("error", "The access token has expired. Please logout and re-login.");
			return "redirect:/index.html";
		}

		String email = (String) session.getAttribute("userEmail");
		OutlookService outlookService = OutlookServiceBuilder.getOutlookService(tokens.getAccessToken(), email);

		FindMeetingRequest findMeetingRequest = new FindMeetingRequest();
		List<Attendees> attendeesList =new ArrayList<Attendees>();
		attendeesList.add(new Attendees(new EmailAddress("Test","test@outlook.com"),"Required"));
		findMeetingRequest.setAttendeesList(attendeesList);
		List<MeetingTimeSlot> meetingTimeSlots = new ArrayList<MeetingTimeSlot>();
		DateTime dateTime = new DateTime().withTimeAtStartOfDay();

		Date startDate = dateTime.plusDays(1).toDate();
		Date endDate = dateTime.plusDays(2).toDate();
		meetingTimeSlots.add(new MeetingTimeSlot(new TimeSlot(startDate,"UTC"),new TimeSlot(endDate,"UTC")));
//		findMeetingRequest.setTimeConstraint(new TimeConstraint("Unrestricted",meetingTimeSlots));
		findMeetingRequest.setMeetingDuration("PT1H");
		findMeetingRequest.setReturnSuggestionReasons(true);
		FindMeetingResponse findMeetingResponse = outlookService.findMeetingTimes(findMeetingRequest)
				.execute().body();
		model.addAttribute("findMeetingResponse", findMeetingResponse);
		return "searchMeetingTimes";
	}
}
