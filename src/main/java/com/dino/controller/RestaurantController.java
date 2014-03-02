package com.dino.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dino.Assembler.LocuVenueAssembler;
import com.dino.Assembler.RestaurantAssembler;
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
    LocuVenueAssembler locuVenueAssembler;
    @Autowired
    LocuSearchService locuSearchService;

    @RequestMapping(value = "/restaurant", method = RequestMethod.GET)
    @ResponseBody
    public List<RestaurantResource> getAllRestaurants() {
        return restaurantAssembler.toResources(restaurantRepository.findAll());
    }

    @RequestMapping(value = "/restaurant", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Void> createRestaurant(@RequestBody Restaurant restaurant) {
        restaurant = restaurantRepository.save(restaurant);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(methodOn(getClass()).getRestaurant(restaurant.getId())).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/restaurant/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestaurantResource getRestaurant(@PathVariable("id") String id) {
        Restaurant restaurant = restaurantRepository.getRestaurant(id);
        return restaurantAssembler.toResource(restaurant);
    }
    
//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    @ResponseBody
//    public List<LocuVenueResource> searchRestaurant(@RequestParam(value="name", required=true) String name, @RequestParam(value="locality", required=true) String locality) {
//        return locuVenueAssembler.toResources(locuSearchService.findRestaurants(name, locality));
//    }
}