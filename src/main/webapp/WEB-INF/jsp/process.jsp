<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
Find Meeting Times

<table class="table">
    <caption>Availability</caption>
    <thead>
    <tr>
        <th>Confidence</th>
        <th>Start Time</th>
        <th>End Time</th>
        <th>Attendee1</th>
        <th>Attendee2</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${findMeetingResponse.meetingTimeSuggestionList}" var="meetingTimeSuggestion">
        <tr>
            <td><c:out value="${meetingTimeSuggestion.confidence}" /></td>
            <td><c:out value="${meetingTimeSuggestion.meetingTimeSlot.start.dateTime}" /></td>
            <td><c:out value="${meetingTimeSuggestion.meetingTimeSlot.end.dateTime}" /></td>
        <c:forEach items="${meetingTimeSuggestion.attendeeAvailabilityList}" var="attendeeAvailability">
            <td><c:out value="${attendeeAvailability.attendees.emailAddress.address}" /> | <c:out value="${attendeeAvailability.availability}" /></td>
        </c:forEach>

        </tr>
    </c:forEach>
    </tbody>
</table>
