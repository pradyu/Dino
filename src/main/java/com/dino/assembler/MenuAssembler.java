package com.dino.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.logging.Logger;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.dino.controller.MenuController;
import com.dino.entity.Menu;
import com.dino.rest.entity.MenuResource;

@Component
public class MenuAssembler extends ResourceAssemblerSupport<Menu, MenuResource> {

    private static Logger LOG = Logger.getLogger(MenuAssembler.class.getName());

    public MenuAssembler() {
        super(MenuController.class, MenuResource.class);
    }

    @Override
    public MenuResource toResource(Menu menu) {
    	if(menu != null){
    		MenuResource retVal = instantiateResource(menu);
            retVal.setMenu(menu);
            retVal.add(linkTo(methodOn(MenuController.class).getMenusByRestaurantId(menu.getRestaurantId())).withSelfRel());
            return retVal;
    	}
        return new MenuResource();
    }
}
