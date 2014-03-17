package com.dino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dino.entity.Menu;
import com.dino.entity.Restaurant;

@Service("locuSearchService")

public interface LocuSearchService {
	
	List<Restaurant> findRestaurants(String name, String locality);
	
	/**
	 * Searches for a Venue using Locu API and category=restaurant
	 * @param name
	 * @param locality
	 * @param cuisine
	 * @param region
	 * @param postal_code
	 * @param country
	 * @param radius
	 * @param street_address
	 * @param open_at
	 * @param has_menu
	 * @return List of Restaurant objects
	 */
	List<Restaurant> findRestaurants(String name, String locality,
			String cuisine, String region, String postal_code, String country,
			Float radius, String street_address, String open_at,
			Boolean has_menu);
	
	/**
	 * Searches for menus of restaurant using Locu API
	 * @param restaurantId
	 * @return List of Menu objects
	 */
	List<Menu> findMenusByRestaurant(String restaurantId);
}
