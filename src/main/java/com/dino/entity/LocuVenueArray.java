package com.dino.entity;

import java.util.ArrayList;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonAutoDetect
public class LocuVenueArray {
	@JsonIgnoreType
	private static class Meta {	
	}
	
	@JsonIgnore
	private Meta meta;
	@JsonProperty
	private ArrayList<LocuVenue> objects;
	
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public ArrayList<LocuVenue> getObjects() {
		return objects;
	}
	public void setObjects(ArrayList<LocuVenue> objects) {
		this.objects = objects;
	}	
	
	

}
