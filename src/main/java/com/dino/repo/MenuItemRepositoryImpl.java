package com.dino.repo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dino.entity.MenuItem;

@Repository("menuItemRepository")
public class MenuItemRepositoryImpl implements MenuItemRepository {

	@Autowired
	MongoOperations operations;

	@Override
	public List<MenuItem> findAll() {
		return operations.findAll(MenuItem.class);
	}

	@Override
	public MenuItem getMenuItemByName(String menuItemName) {
		Query query = query(where("name").is(menuItemName));
		return operations.findOne(query, MenuItem.class);
	}
	
	@Override
	public List<MenuItem> getMenuItemsByRestaurant(String restaurantName) {
		Query query = query(where("restaurantName").is(restaurantName));
		return operations.find(query, MenuItem.class);
	}

	@Override
	public List<MenuItem> getMenuItemsByMenu(String menuId) {
		Query query = query(where("menuId").is(menuId));
		return operations.find(query, MenuItem.class);
	}

	@Override
	public MenuItem getMenuItem(String id) {
		Query query = query(where("menuId").is(id));
		return operations.findOne(query, MenuItem.class);
	}

	@Override
	public MenuItem save(MenuItem menuItem) {
		operations.save(menuItem);
		return menuItem;
	}

	@Override
	public List<MenuItem> saveAll(List<MenuItem> menuItemList) {
		List<MenuItem> list = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemList) {
			list.add(save(menuItem));
		}
		return Collections.unmodifiableList(list);
	}

	@Override
	public void delete(MenuItem menuItem) {
		operations.remove(menuItem);
	}

	@Override
	public void deleteAll(List<MenuItem> menuItemList) {
		for (MenuItem menuItem : menuItemList) {
			delete(menuItem);
		}
	}

}
