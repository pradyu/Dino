package com.dino.entity;

import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Menu extends AbstractEntity {
	@Field
	private String restaurantName;
	private Map<String,MenuItem> menuItemList;
	
	public Menu(){
	}
	
	public Menu(String name) {
		this.restaurantName = name;
	}
	
	public Map<String,MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(Map<String,MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public String getRestaurantId() {
		return restaurantName;
	}

	public void setRestaurantId(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
}
