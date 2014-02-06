package com.dino.controller;

import com.dino.Assembler.RestaurantAssembler;
import com.dino.entity.Restaurant;
import com.dino.repo.RestaurantRepository;
import com.dino.rest.entity.RestaurantResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    RestaurantAssembler restaurantAssembler;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<RestaurantResource> getAllRestaurants() {
        return restaurantAssembler.toResources(restaurantRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> createRestaurant(@RequestBody Restaurant restaurant) {
        restaurant = restaurantRepository.save(restaurant);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(methodOn(getClass()).getRestaurant(restaurant.getId())).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestaurantResource getRestaurant(@PathVariable("id") BigInteger id) {
        Restaurant restaurant = restaurantRepository.getRestaurant(id);
        return restaurantAssembler.toResource(restaurant);
    }
}