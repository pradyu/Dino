//package com.dino.yelp;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import com.dino.entity.Location;
//import com.dino.entity.Restaurant;
//
//public class YelpUtil {
//
//	// Yelp API Access key
//	private static final String CONSUMER_KEY = "WAwKOMmjCkOIgbCWvcGpfA";
//	private static final String CONSUMER_SECRET = "iooDVASGoMRwm-ZFVJdlAwN5EGA";
//	private static final String TOKEN = "t1r-BTn1WWiAEWcGktrFYcwWHKOfsYlh";
//	private static final String TOKEN_SECRET = "cxp6oH_lU7DlIzF-uGNOus9uHQY";
//
//	//JSON Yelp API Keys
//	private static final String KEY_BUSINESSES = "businesses";
//	private static final String KEY_NAME = "name";
//	private static final String KEY_PHONE = "display_phone";
//	private static final String KEY_LOCATION = "location";
//	private static final String KEY_URL = "mobile_url";
//	private static final String KEY_REVIEW_COUNT = "review_count";
//	private static final String KEY_RATING = "rating";
//
//	//JSON Yelp API Keys for Location[]
//	private static final String KEY_CITY = "city";
//	private static final String KEY_ZIP_CODE = "postal_code";
//	private static final String KEY_ADDRESS = "address";
//	private static final String KEY_STATE_CODE = "state_code";
//	private static final String KEY_CROSS_STREETS = "cross_streets";
//	private static final String KEY_COUNTRY_CODE = "country_code";
//	private static final String KEY_NEIGHBORHOOD = "neighborhoods";
//	private static final String KEY_COORDINATES = "coordinate";
//
//	private YelpUtil(){
//	}
//	
//	private static String sendYelpRequest(String keyword, String location) {
//		Yelp yelp = new Yelp(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
//		return yelp.search(keyword, location);
//	}
//
//	private static List<Restaurant> parseJSON(String jsonString)
//			throws JSONException {
//		JSONObject jsonOBJ = new JSONObject(jsonString);
//		JSONArray businessArray = jsonOBJ.getJSONArray(KEY_BUSINESSES);
//		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
//		for (int i = 0; i < businessArray.length(); i++) {
//			Restaurant restaurant = new Restaurant();
//			JSONObject currentBusiness = businessArray.getJSONObject(i);
//			Object nameObj = currentBusiness.get(KEY_NAME);
//			if (nameObj != null)
//				restaurant.setName(nameObj.toString());
//			Object phoneObj = currentBusiness.get(KEY_PHONE);
//			if (phoneObj != null)
//				restaurant.setPhoneNumber(phoneObj.toString());
//			Object locationObj = currentBusiness.get(KEY_LOCATION);
//			if (locationObj != null) {
//				Location location = parseLocation(locationObj.toString());
//				restaurant.setLocation(location);
//			}
//
//			restaurantList.add(restaurant);
//			Object urlObj = currentBusiness.get(KEY_URL);
//			if (urlObj != null)
//				restaurant.setUrl(urlObj.toString());
//			Object reviewObj = currentBusiness.get(KEY_REVIEW_COUNT);
//			if (reviewObj != null)
//				restaurant
//				.setReviewCount(Integer.parseInt(reviewObj.toString()));
//			Object ratingObj = currentBusiness.get(KEY_RATING);
//			if (ratingObj != null)
//				restaurant.setRating(Double.parseDouble(ratingObj.toString()));
//		}
//		return restaurantList;
//	}
//
//	private static Location parseLocation(String jsonLocationStr)
//			throws JSONException {
//		Location location = new Location();
//		JSONObject jsonOBJ = new JSONObject(jsonLocationStr);
//
//		Object cityObj = jsonOBJ.get(KEY_CITY);
//		if (cityObj != null)
//			location.setCity(cityObj.toString());
//
//		Object zipCodeObj = jsonOBJ.get(KEY_ZIP_CODE);
//		if (zipCodeObj != null)
//			location.setZipCode(zipCodeObj.toString());
//
//		JSONArray jAddressArray = jsonOBJ.getJSONArray(KEY_ADDRESS);
//		StringBuffer addressBuffer = new StringBuffer();
//		for (Integer i = 0; i < jAddressArray.length(); i++) {
//			addressBuffer.append(jAddressArray.get(i));
//		}
//		location.setAddress(addressBuffer.toString());
//
//		Object stateCodeObj = jsonOBJ.get(KEY_STATE_CODE);
//		if (stateCodeObj != null)
//			location.setStateCode(stateCodeObj.toString());
//
//		Object countryCodeObj = jsonOBJ.get(KEY_COUNTRY_CODE);
//		if (countryCodeObj != null)
//			location.setCountryCode(countryCodeObj.toString());
//
//		if (jsonOBJ.get(KEY_NEIGHBORHOOD) != null) {
//			Object neighborhoodObj = jsonOBJ.getJSONArray(KEY_NEIGHBORHOOD)
//					.get(0);
//			location.setNeighborhood(neighborhoodObj.toString());
//		}
//
//		if (jsonOBJ.has(KEY_CROSS_STREETS)
//				&& jsonOBJ.get(KEY_CROSS_STREETS) != null) {
//			Object crossStreetsObj = jsonOBJ.get(KEY_CROSS_STREETS);
//			location.setCrossStreets(crossStreetsObj.toString());
//		}
//
//		String[] coordinateArray = new String[2];
//		coordinateArray[0] = jsonOBJ.getJSONObject(KEY_COORDINATES)
//				.get("longitude").toString();
//		coordinateArray[1] = jsonOBJ.getJSONObject(KEY_COORDINATES)
//				.get("latitude").toString();
//		location.setCoordinates(coordinateArray);
//
//		return location;
//	}
//	
//	public static List<Restaurant> getRestaurantsFromYelp(String searchKeyword, String location) throws JSONException{
//		String yelpResponse = sendYelpRequest(searchKeyword, location);
//		return parseJSON(yelpResponse);
//	}
//
//}
