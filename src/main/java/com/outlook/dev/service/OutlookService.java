package com.outlook.dev.service;

import retrofit2.Call;
import retrofit2.http.*;

public interface OutlookService {
	
	@GET("/api/v2.0/me")
	Call<OutlookUser> getCurrentUser();

	@GET("/api/v2.0/me/mailfolders/{folderid}/messages")
	Call<PagedResult<Message>> getMessages(
	  @Path("folderid") String folderId,
	  @Query("$orderby") String orderBy,
	  @Query("$select") String select,
	  @Query("$top") Integer maxResults
	);
	
	@GET("/api/v2.0/me/events")
	Call<PagedResult<Event>> getEvents(
	  @Query("$orderby") String orderBy,
	  @Query("$select") String select,
	  @Query("$top") Integer maxResults
	);

	@Headers("Prefer: outlook.timezone=\"India Standard Time\"")
	@POST("/api/v2.0/me/findmeetingtimes")
	Call<FindMeetingResponse> findMeetingTimes(@Body FindMeetingRequest body);
	
	@GET("/api/v2.0/me/contacts")
	Call<PagedResult<Contact>> getContacts(
		@Query("$orderby") String orderBy,
	  @Query("$select") String select,
	  @Query("$top") Integer maxResults
	);
}
