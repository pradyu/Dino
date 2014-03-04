package com.dino.entity;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
@Entity
public class Restaurant extends AbstractEntity {

	@Field("name")
	@JsonProperty
	private String name;
	@JsonProperty
	private Double rating;
	@JsonProperty
	private String owner;
	@JsonProperty
	private String phoneNumber;
	@JsonProperty
	private List<String> reviewList;
	@JsonProperty
	private Integer reviewCount;
	@JsonProperty
	private String category;
	@JsonProperty
	private String url;
	@JsonProperty
	private Location location;

	public Restaurant(String name) {
		this.name = name;
	}

	public Restaurant() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<String> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<String> reviewList) {
		this.reviewList = reviewList;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
