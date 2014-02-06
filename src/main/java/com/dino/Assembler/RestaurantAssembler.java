package com.dino.Assembler;

import com.dino.controller.RestaurantController;
import com.dino.entity.Restaurant;
import com.dino.rest.entity.RestaurantResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class RestaurantAssembler extends ResourceAssemblerSupport<Restaurant, RestaurantResource> {

    public RestaurantAssembler() {
        super(RestaurantController.class, RestaurantResource.class);
    }

    @Override
    public RestaurantResource toResource(Restaurant restaurant) {
        return createResourceWithId(restaurant.getId(), restaurant);
    }
}
