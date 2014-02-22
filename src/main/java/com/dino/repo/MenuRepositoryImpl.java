package com.dino.repo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dino.entity.Menu;

@Repository("menuRepository")
public class MenuRepositoryImpl implements MenuRepository {

	@Autowired
	MongoOperations operations;

	@Override
	public List<Menu> findAll() {
		return operations.findAll(Menu.class);
	}

	@Override
	public Menu getMenuByRestaurant(String restaurantName) {
		Query query = query(where("restaurantName").is(restaurantName));
		return operations.findOne(query, Menu.class);
	}

	@Override
	public Menu getMenu(String id) {
		Query query = query(where("id").is(id));
		return operations.findOne(query, Menu.class);
	}

	@Override
	public Menu save(Menu menu) {
		operations.save(menu);
		return menu;
	}

	@Override
	public void delete(Menu menu) {
		operations.remove(menu);
	}
}
