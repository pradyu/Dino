package com.dino.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dino.assembler.RestaurantAssembler;
import com.dino.entity.Restaurant;
import com.dino.repo.RestaurantRepository;
import com.dino.rest.entity.RestaurantResource;
import com.dino.service.LocuSearchService;

@Controller
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	RestaurantAssembler restaurantAssembler;
	@Autowired
	LocuSearchService locuSearchService;

	@RequestMapping(value = "/restaurant", method = RequestMethod.GET)
	@ResponseBody
	public List<RestaurantResource> getAllRestaurants() {
		return restaurantAssembler.toResources(restaurantRepository.findAll());
	}

	@RequestMapping(value = "/restaurant", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<Void> createRestaurant(
			@RequestBody Restaurant restaurant) {
		restaurant = restaurantRepository.save(restaurant);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(linkTo(
				methodOn(getClass()).getRestaurant(restaurant.getId())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
	@ResponseBody
	public RestaurantResource getRestaurant(@PathVariable("id") String id) {
		Restaurant restaurant = restaurantRepository.getRestaurant(id);
		return restaurantAssembler.toResource(restaurant);
	}

	@RequestMapping(value = "/restaurant/search", method = RequestMethod.GET)
	@ResponseBody
	public List<RestaurantResource> searchRestaurant(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "locality", required = false) String locality,
			@RequestParam(value = "cuisine", required = false) String cuisine,
			@RequestParam(value = "region", required = false) String region,
			@RequestParam(value = "postal_code", required = false) String postal_code,
			@RequestParam(value = "country", required = false) String country, 
			@RequestParam(value = "radius", required = false) Float radius, 
			@RequestParam(value = "street_address", required = false) String street_address,
			@RequestParam(value = "open_at", required = false) String open_at,
			@RequestParam(value = "has_menu", required = false) Boolean has_menu) {
		List<Restaurant> restaurantList = locuSearchService
		.findRestaurants(name, locality, cuisine, region, postal_code, country, radius, street_address, open_at, has_menu);
		return restaurantAssembler.toResources(restaurantList);
	}
	
	@RequestMapping(value = "/restaurant/save", method = RequestMethod.GET)
	@ResponseBody
	public List<RestaurantResource> searchAndSaveRestaurant(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "locality", required = true) String locality) {
		List<Restaurant> restaurantList = locuSearchService
		.findRestaurants(name, locality);
		for(Restaurant restaurant : restaurantList){
			restaurantRepository.save(restaurant);
		}
		return restaurantAssembler.toResources(restaurantList);
	}
}