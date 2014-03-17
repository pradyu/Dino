//package com.dino.assembler;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//import java.util.logging.Logger;
//
//import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
//import org.springframework.stereotype.Component;
//
//import com.dino.controller.RestaurantController;
//import com.dino.entity.LocuVenue;
//import com.dino.rest.entity.LocuVenueResource;
//
//@Component
//public class LocuMenuAssembler extends
//ResourceAssemblerSupport<LocuVenue, LocuVenueResource> {
//
//	private static Logger LOG = Logger.getLogger(LocuMenuAssembler.class
//			.getName());
//
//	public LocuMenuAssembler() {
//		super(RestaurantController.class, LocuVenueResource.class);
//	}
//
//	@Override
//	public LocuVenueResource toResource(LocuVenue locuVenue) {
//		LocuVenueResource retVal = instantiateResource(locuVenue);
//		retVal.setLocuVenue(locuVenue);
//		retVal.add(linkTo(
//				methodOn(RestaurantController.class).searchRestaurant(
//						locuVenue.getName(), locuVenue.getLocality())).withSelfRel());
//		return retVal;
//
//	}
//	
//	
//}