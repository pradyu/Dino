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
		String baseUrl = "http://api.locu.com/v1_0/venue/search/";
		Map<String,String> urlMap = new TreeMap<String, String>();
		urlMap.put("name", name);
		urlMap.put("locality", locality);
		String queryString = this.getQueryString(baseUrl, urlMap);
		final ResponseEntity<LocuVenueArray> responseEntity = restTemplate
				.getForEntity(queryString, LocuVenueArray.class);
		LocuVenueArray resultArray = responseEntity.getBody();
		ArrayList<Restaurant> locuVenueList = resultArray.getObjects();
		return locuVenueList;
	}

	@Override
	public List<Menu> findMenusByRestaurant(String locuRestaurantId) {
		String baseUrl = "http://api.locu.com/v1_0/venue/"+locuRestaurantId+"/";
		String queryString = this.getQueryString(baseUrl, new TreeMap<String, String>());
		final ResponseEntity<LocuVenueArray> responseEntity = restTemplate
				.getForEntity(queryString, LocuVenueArray.class);
		LocuVenueArray resultArray = responseEntity.getBody();
		ArrayList<Restaurant> locuVenueList = resultArray.getObjects();
		if(locuVenueList != null && locuVenueList.size() > 0){
			return locuVenueList.get(0).getMenus();
		}
		return Collections.emptyList();
	}
	
	private String getQueryString(String baseUrl, Map<String, String> urlMap) {
		urlMap.put("api_key", API_KEY);
		urlMap.put("category", "restaurant");
		String url = DinoUtilities.buildUrl(baseUrl, urlMap);
		return url;
	}

}
