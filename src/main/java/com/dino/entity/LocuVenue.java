//package com.dino.entity;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//@Document
//@Entity
//@JsonIgnoreProperties({ "facebook_url", "open_hours", "redirected_from",
//		"twitter_id" })
//public class LocuVenue extends AbstractEntity {
//	@JsonProperty
//	private String locu_id;
//	@JsonProperty
//	private String name;
//	@JsonProperty
//	private String short_name;
//	@JsonProperty
//	private String locality;
//	private String description;
//	@JsonProperty
//	private String website_url;
//	@JsonProperty
//	private String menu_url;
//	@JsonProperty
//	private String street_address;
//	@JsonProperty
//	private String[] cuisines;
//	@JsonProperty
//	private String region;
//	@JsonProperty("long")
//	private Long longitude;
//	@JsonProperty
//	private String phone;
//	@JsonProperty
//	private String postal_code;
//	@JsonProperty
//	private String[] categories;
//	@JsonProperty
//	private Boolean has_menu;
//	@JsonProperty
//	private String country;
//	@JsonProperty("lat")
//	private Long lattitude;
//	@JsonProperty
//	private String id;
//	@JsonProperty
//	private String resource_uri;
//	@JsonProperty
//	private List<LocuMenu> menus;
//	@JsonProperty
//	private List<String> similar_venues;
//
//	public String[] getCuisines() {
//		return cuisines;
//	}
//
//	public void setCuisines(String[] cuisines) {
//		this.cuisines = cuisines;
//	}
//
//	public String getLocu_id() {
//		return locu_id;
//	}
//
//	public void setLocu_id(String locu_id) {
//		this.locu_id = locu_id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getShort_name() {
//		return short_name;
//	}
//
//	public void setShort_name(String short_name) {
//		this.short_name = short_name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public String getWebsite_url() {
//		return website_url;
//	}
//
//	public void setWebsite_url(String website_url) {
//		this.website_url = website_url;
//	}
//
//	public String getMenu_url() {
//		return menu_url;
//	}
//
//	public void setMenu_url(String menu_url) {
//		this.menu_url = menu_url;
//	}
//
//	public String getLocality() {
//		return locality;
//	}
//
//	public void setLocality(String locality) {
//		this.locality = locality;
//	}
//
//	public String getStreet_address() {
//		return street_address;
//	}
//
//	public void setStreet_address(String street_address) {
//		this.street_address = street_address;
//	}
//
//	public String getRegion() {
//		return region;
//	}
//
//	public void setRegion(String region) {
//		this.region = region;
//	}
//
//	public Long getLongitude() {
//		return longitude;
//	}
//
//	public void setLongitude(Long longitude) {
//		this.longitude = longitude;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getPostal_code() {
//		return postal_code;
//	}
//
//	public void setPostal_code(String postal_code) {
//		this.postal_code = postal_code;
//	}
//
//	public String[] getCategories() {
//		return categories;
//	}
//
//	public void setCategories(String[] categories) {
//		this.categories = categories;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	@Override
//	public String toString() {
//		StringBuffer sb = new StringBuffer();
//		sb.append("id: " + id + "\n").append("name: " + name + "\n")
//				.append("locality: " + locality + "\n")
//				.append("street_address: " + street_address + "\n")
//				.append("postal_code: " + postal_code + "\n")
//				.append("country: " + country + "\n")
//				.append("phone: " + phone + "\n")
//				.append("resource_uri: " + resource_uri + "\n");
//		for (LocuMenu menu : menus) {
//			sb.append(menu.toString() + "\n");
//		}
//		return sb.toString();
//	}
//
//	public Boolean getHas_menu() {
//		return has_menu;
//	}
//
//	public void setHas_menu(Boolean has_menu) {
//		this.has_menu = has_menu;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public Long getLattitude() {
//		return lattitude;
//	}
//
//	public void setLattitude(Long lattitude) {
//		this.lattitude = lattitude;
//	}
//
//	public String getResource_uri() {
//		return resource_uri;
//	}
//
//	public void setResource_uri(String resource_uri) {
//		this.resource_uri = resource_uri;
//	}
//
//	public List<LocuMenu> getMenus() {
//		return menus;
//	}
//
//	public void setMenus(List<LocuMenu> menus) {
//		this.menus = menus;
//	}
//
//	public List<String> getSimilar_venues() {
//		return similar_venues;
//	}
//
//	public void setSimilar_venues(List<String> similar_venues) {
//		this.similar_venues = similar_venues;
//	}
//}
