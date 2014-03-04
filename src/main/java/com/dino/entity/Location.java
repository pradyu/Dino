package com.dino.entity;

public class Location {
	private String city;
	private String zipCode;
	private String address;
	private String stateCode;
	private String countryCode;
	private String crossStreets;
	private String neighborhood;
	private String[] coordinates;
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}
	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return the crossStreets
	 */
	public String getCrossStreets() {
		return crossStreets;
	}
	/**
	 * @param crossStreets the crossStreets to set
	 */
	public void setCrossStreets(String crossStreets) {
		this.crossStreets = crossStreets;
	}
	/**
	 * @return the neighborhoods
	 */
	public String getNeighborhood() {
		return neighborhood;
	}
	/**
	 * @param neighborhoods the neighborhoods to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	/**
	 * @return the coordinates
	 */
	public String[] getCoordinates() {
		return coordinates;
	}
	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(String[] coordinates) {
		this.coordinates = coordinates;
	}

}
