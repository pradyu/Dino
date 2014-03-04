package com.dino.rest.entity;

import org.springframework.hateoas.ResourceSupport;

import com.dino.entity.Menu;

public class MenuResource extends ResourceSupport {

    private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
