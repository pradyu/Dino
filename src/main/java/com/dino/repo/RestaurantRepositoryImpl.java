package com.dino.repo;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dino.entity.Restaurant;

@Repository("restaurantRepository")
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @Autowired
    MongoOperations operations;

    @Override
    public List<Restaurant> findAll() {
    	return operations.findAll(Restaurant.class);
    }

    @Override
    public Restaurant getRestaurantByName(String name) {
        Query query = query(where("name").is(name));
        return operations.findOne(query, Restaurant.class);
    }

    @Override
    public Restaurant getRestaurant(String id) {
        Query query = query(where("id").is(id));
        return operations.findOne(query, Restaurant.class);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        operations.save(restaurant);
        return restaurant;
    }

    @Override
    public void delete(Restaurant restaurant) {
        operations.remove(restaurant);
    }
}
