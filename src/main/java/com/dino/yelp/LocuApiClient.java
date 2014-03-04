package com.dino.yelp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dino.entity.LocuVenue;
import com.dino.entity.LocuVenueArray;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class LocuApiClient {
	public void getVenue(String term, String location) throws JsonParseException, JsonMappingException, IOException{
		String url = this.getUrl(term, location);
		RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<LocuVenueArray> responseEntity = restTemplate
				.getForEntity(url, LocuVenueArray.class);
		System.out.println(responseEntity.getBody().toString());
		LocuVenueArray resultArray = responseEntity.getBody();
		ArrayList<LocuVenue> locuVenueList = resultArray.getObjects();
		for(LocuVenue lv : locuVenueList){
			System.out.println(lv.toString());
		}
	}
	
	private String getUrl(String term, String location){
		String baseUrl = "http://api.locu.com/v1_0/venue/search/";
		Map<String,String> urlMap = new TreeMap<String, String>();
		urlMap.put("api_key", "3f5ece83d57ccf1ee4ea5234d4de715e4bd356a5");
		urlMap.put("name", term);
		urlMap.put("locality", location);
		urlMap.put("category", "restaurant");
		String url = DinoUtilities.buildUrl(baseUrl, urlMap);
		System.out.println(url);
		return url;
		
	}
	
	public static void main(String...strings){
		LocuApiClient client = new LocuApiClient();
		try {
			client.getVenue("cafe orlin", "new york");
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
