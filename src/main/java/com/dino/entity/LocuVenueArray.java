package com.dino.entity;

import java.util.ArrayList;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonAutoDetect
@JsonIgnoreProperties({"not_found"})
public class LocuVenueArray {
	@JsonIgnoreType
	private static class Meta {	
	}
	
	@JsonIgnore
	private Meta meta;
	@JsonProperty
	private ArrayList<Restaurant> objects;
	
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	public ArrayList<Restaurant> getObjects() {
		return objects;
	}
	public void setObjects(ArrayList<Restaurant> objects) {
		this.objects = objects;
	}	
	
	

}
