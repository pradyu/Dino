package com.dino.rest.entity;

import org.springframework.hateoas.ResourceSupport;

import com.dino.entity.LocuVenue;

public class LocuVenueResource extends ResourceSupport {

	private LocuVenue locuVenue;

	public LocuVenue getLocuVenue() {
		return locuVenue;
	}

	public void setLocuVenue(LocuVenue locuVenue) {
		this.locuVenue = locuVenue;
	}

}
