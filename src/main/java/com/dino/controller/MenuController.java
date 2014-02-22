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

import com.dino.Assembler.MenuAssembler;
import com.dino.entity.Menu;
import com.dino.repo.MenuRepository;
import com.dino.rest.entity.MenuResource;

@Controller
public class MenuController {

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuAssembler menuAssembler;

    @RequestMapping(value = "/restaurant/{id}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuResource> getAllRestaurants() {
        return menuAssembler.toResources(menuRepository.findAll());
    }

    @RequestMapping(value = "/restaurant/{id}/menu", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<Void> createMenu(@RequestBody Menu menu) {
        menu = menuRepository.save(menu);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(linkTo(methodOn(getClass()).getMenu(menu.getId())).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/restaurant/{id}/menu/{id}", method = RequestMethod.GET)
    @ResponseBody
    public MenuResource getMenu(@PathVariable("id") String id) {
        Menu menu = menuRepository.getMenu(id);
        return menuAssembler.toResource(menu);
    }
}