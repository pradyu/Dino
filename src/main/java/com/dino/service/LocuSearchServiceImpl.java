package com.dino.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dino.entity.LocuVenueArray;
import com.dino.entity.Menu;
import com.dino.entity.Restaurant;
import com.dino.yelp.DinoUtilities;

public class LocuSearchServiceImpl implements LocuSearchService {

	@Autowired
	RestTemplate restTemplate;
	private final static String API_KEY = "3f5ece83d57ccf1ee4ea5234d4de715e4bd356a5";

	@Override
	public List<Restaurant> findRestaurants(String name, String locality) {
		return findRestaurants(name, locality, null, null, null, null, null,
				null, null, null);
	}

	@Override
	public List<Restaurant> findRestaurants(String name, String locality,
			String cuisine, String region, String postal_code, String country,
			Float radius, String street_address, String open_at,
			Boolean has_menu) {
		String baseUrl = "http://api.locu.com/v1_0/venue/search/";
		Map<String, Object> urlMap = new TreeMap<String, Object>();
		if (name != null)
			urlMap.put("name", name);
		if (locality != null)
			urlMap.put("locality", locality);
		if (cuisine != null)
			urlMap.put("cuisine", cuisine);
		if (region != null)
			urlMap.put("region", region);
		if (postal_code != null)
			urlMap.put("postal_code", postal_code);
		if (country != null)
			urlMap.put("country", country);
		if (radius != null)
			urlMap.put("radius", radius);
		if (street_address != null)
			urlMap.put("street_address", street_address);
		if (open_at != null)
			urlMap.put("open_at", open_at);
		if (has_menu != null)
			urlMap.put("has_menu", has_menu);
		String queryString = this.getQueryString(baseUrl, urlMap);
		final ResponseEntity<LocuVenueArray> responseEntity = restTemplate
				.getForEntity(queryString, LocuVenueArray.class);
		LocuVenueArray resultArray = responseEntity.getBody();
		ArrayList<Restaurant> locuVenueList = resultArray.getObjects();
		return locuVenueList;
	}

	@Override
	public List<Menu> findMenusByRestaurant(String locuRestaurantId) {
		String baseUrl = "http://api.locu.com/v1_0/venue/" + locuRestaurantId
				+ "/";
		String queryString = this.getQueryString(baseUrl,
				new TreeMap<String, Object>());
		final ResponseEntity<LocuVenueArray> responseEntity = restTemplate
				.getForEntity(queryString, LocuVenueArray.class);
		LocuVenueArray resultArray = responseEntity.getBody();
		ArrayList<Restaurant> locuVenueList = resultArray.getObjects();
		if (locuVenueList != null && locuVenueList.size() > 0) {
			return locuVenueList.get(0).getMenus();
		}
		return Collections.emptyList();
	}

	private String getQueryString(String baseUrl, Map<String, Object> urlMap) {
		urlMap.put("api_key", API_KEY);
		urlMap.put("category", "restaurant");
		String url = DinoUtilities.buildUrl(baseUrl, urlMap);
		System.out.println(url);
		return url;
	}
}
