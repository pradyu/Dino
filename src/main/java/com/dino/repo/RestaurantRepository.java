package com.dino.repo;


import com.dino.entity.Restaurant;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;
import java.util.List;

public interface RestaurantRepository extends Repository<Restaurant, BigInteger> {

    List<Restaurant> findAll();

    Restaurant getRestaurantByName(String name);

    Restaurant getRestaurant(BigInteger id);

    Restaurant save(Restaurant restaurant);

    void delete(Restaurant restaurant);
}
