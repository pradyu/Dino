package com.dino.repo;

import com.dino.entity.Restaurant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ActiveProfiles("test")
public class RestaurantRepositoryImplTest extends AbstractTest {

    @Autowired
    @Qualifier("restaurantRepository")
    RestaurantRepository restaurantRepository;

    @Test
    public void canSaveRestaurant() {
        Restaurant restaurant = new Restaurant();
        Restaurant retVal = restaurantRepository.save(restaurant);
        assertNotNull(retVal);
    }

    @Test
    public void canGetRestaurantByName() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("sample");
        restaurantRepository.save(restaurant);
        Restaurant retVal = restaurantRepository.getRestaurantByName("sample");
        assertNotNull(retVal);
    }

    @Test
    public void canGetAllRestaurants() {
        restaurantRepository.save(new Restaurant());
        restaurantRepository.save(new Restaurant());
        List<Restaurant> retVal = restaurantRepository.findAll();
        assertNotNull(retVal);
        assertTrue(retVal.size() == 2);
    }
}
