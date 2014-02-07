package com.dino.Assembler;

import com.dino.controller.RestaurantController;
import com.dino.entity.Restaurant;
import com.dino.rest.entity.RestaurantResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class RestaurantAssembler extends ResourceAssemblerSupport<Restaurant, RestaurantResource> {

    private static Logger LOG = Logger.getLogger(RestaurantAssembler.class.getName());

    public RestaurantAssembler() {
        super(RestaurantController.class, RestaurantResource.class);
    }

    @Override
    public RestaurantResource toResource(Restaurant restaurant) {

        RestaurantResource retVal = instantiateResource(restaurant);
        retVal.setRestaurant(restaurant);
        retVal.add(linkTo(methodOn(RestaurantController.class).getRestaurant(restaurant.getId())).withSelfRel());
        return retVal;
    }
}
