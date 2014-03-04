package com.dino.yelp;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties
public class Meta {
	@JsonIgnore
	private Integer limit;
	@JsonIgnore
	private Integer cache_expiry;
	
	
}
