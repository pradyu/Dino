package com.dino.repo;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.dino.entity.Menu;

public interface MenuRepository extends Repository<Menu, String> {

    List<Menu> findAll();

    List<Menu> getMenuListByRestaurant(String restaurantId);

    Menu getMenu(String id);

    Menu save(Menu menu);

    void delete(Menu menu);
}
