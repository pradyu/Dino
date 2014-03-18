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
import org.springframework.web.bind.annotation.ResponseBody;

import com.dino.assembler.MenuAssembler;
import com.dino.entity.Menu;
import com.dino.repo.MenuRepository;
import com.dino.rest.entity.MenuResource;
import com.dino.service.LocuSearchService;

@Controller
public class MenuController {

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuAssembler menuAssembler;
    @Autowired
    LocuSearchService locuSearchService;

    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuResource> getAllMenus(@PathVariable String restaurantId) {
        return menuAssembler.toResources(menuRepository.getMenuListByRestaurant(restaurantId));
    }

    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Void> createMenu(@RequestBody Menu menu, @PathVariable("restaurantId") String restaurantId) {
        menu = menuRepository.save(menu);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(methodOn(getClass()).getMenusByRestaurantId(restaurantId)).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/restaurant/{restaurantId}/menu/{menuid}", method = RequestMethod.GET)
    @ResponseBody
    public MenuResource getMenu(@PathVariable("restaurantId") String restaurantId, @PathVariable("menuid") String menuId)  {
        Menu menu = menuRepository.getMenu(menuId);
        menu.setRestaurantId(restaurantId);
        return menuAssembler.toResource(menu);
    }
    
    @RequestMapping(value = "/restaurant/search/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuResource> getMenusByRestaurantId(@PathVariable("restaurantId") String restaurantId) {
    	List<Menu> menuList = locuSearchService.findMenusByRestaurant(restaurantId);
    	for(Menu menu: menuList){
    		menu.setRestaurantId(restaurantId);
    	}
    	return menuAssembler.toResources(menuList);
    }
    
    @RequestMapping(value = "/restaurant/save/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuResource> saveMenusByRestaurantId(@PathVariable("restaurantId") String restaurantId) {
    	List<Menu> menuList = locuSearchService.findMenusByRestaurant(restaurantId);
    	for(Menu menu: menuList){
    		menu.setRestaurantId(restaurantId);
    		menu = menuRepository.save(menu);
    	}
    	return menuAssembler.toResources(menuList);
    }
}