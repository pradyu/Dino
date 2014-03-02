package com.dino.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dino.entity.LocuVenue;
import com.dino.entity.LocuVenueArray;
import com.dino.yelp.DinoUtilities;


public class LocuSearchServiceImpl implements LocuSearchService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<LocuVenue> findRestaurants(String name, String locality) {
		String url = this.getUrl(name, locality);

		final ResponseEntity<LocuVenueArray> responseEntity = restTemplate
				.getForEntity(url, LocuVenueArray.class);
		System.out.println(responseEntity.getBody().toString());
		LocuVenueArray resultArray = responseEntity.getBody();
		ArrayList<LocuVenue> locuVenueList = resultArray.getObjects();
		for (LocuVenue lv : locuVenueList) {
			System.out.println(lv.toString());
		}
		return locuVenueList;
	}

	private String getUrl(String term, String location) {
		String baseUrl = "http://api.locu.com/v1_0/venue/search/";
		Map<String, String> urlMap = new TreeMap<String, String>();
		urlMap.put("api_key", "3f5ece83d57ccf1ee4ea5234d4de715e4bd356a5");
		urlMap.put("name", term);
		urlMap.put("locality", location);
		urlMap.put("category", "restaurant");
		String url = DinoUtilities.buildUrl(baseUrl, urlMap);
		System.out.println(url);
		return url;

	}

}
