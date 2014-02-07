package com.dino.rest.entity;

import com.dino.entity.Restaurant;
import org.springframework.hateoas.ResourceSupport;

public class RestaurantResource extends ResourceSupport {

    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
