package com.dino.yelp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dino.entity.LocuVenueArray;
import com.dino.entity.Restaurant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class LocuApiClient {
	private final static String API_KEY = "3f5ece83d57ccf1ee4ea5234d4de715e4bd356a5";

	public LocuVenueArray getVenueArray(String term, String location)
			throws JsonParseException, JsonMappingException, IOException {
		String baseUrl = "http://api.locu.com/v1_0/venue/search/";
		Map<String, String> urlMap = new TreeMap<String, String>();
		urlMap.put("name", term);
		urlMap.put("locality", location);
		String url = this.getUrl(baseUrl, urlMap);
		RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<LocuVenueArray> responseEntity = restTemplate
				.getForEntity(url, LocuVenueArray.class);
		LocuVenueArray resultArray = responseEntity.getBody();
		return resultArray;
	}

	private String getUrl(String baseUrl, Map<String, String> urlMap) {
		urlMap.put("api_key", API_KEY);
		urlMap.put("category", "restaurant");
		String url = DinoUtilities.buildUrl(baseUrl, urlMap);
		return url;

	}

	private LocuVenueArray getMenu(String resourceUrl) {
		String baseUrl = "http://api.locu.com" + resourceUrl;
		String url = getUrl(baseUrl, new TreeMap<String, String>());
		RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<LocuVenueArray> responseEntity = restTemplate
				.getForEntity(url, LocuVenueArray.class);
		LocuVenueArray resultArray = responseEntity.getBody();
		return resultArray;
	}

	public static void main(String... strings) {
		LocuApiClient client = new LocuApiClient();
		try {
			LocuVenueArray venueArray = client.getVenueArray("cafe orlin",
					"new york");
			ArrayList<Restaurant> locuVenueList = venueArray.getObjects();
			Restaurant locuVenue = locuVenueList.get(0);
			client.getMenu(locuVenue.getResource_uri());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
