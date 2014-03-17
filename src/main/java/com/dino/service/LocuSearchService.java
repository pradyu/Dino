package com.dino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dino.entity.Menu;
import com.dino.entity.Restaurant;

@Service("locuSearchService")
public interface LocuSearchService {
	List<Restaurant> findRestaurants(String name, String locality);
	List<Menu> findMenusByRestaurant(String restaurantId);
}
