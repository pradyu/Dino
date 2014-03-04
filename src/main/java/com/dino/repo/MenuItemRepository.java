package com.dino.repo;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.dino.entity.MenuItem;

public interface MenuItemRepository extends Repository<MenuItem, String> {

    List<MenuItem> findAll();

    MenuItem getMenuItem(String id);
    
    MenuItem getMenuItemByName(String menuItemName);
    
    List<MenuItem> getMenuItemsByRestaurant(String restaurantName);
    
    List<MenuItem> getMenuItemsByMenu(String menuId);
    
    MenuItem save(MenuItem menuItem);
    
    List<MenuItem> saveAll(List<MenuItem> menuItemList);

    void delete(MenuItem menuItem);
    
    void deleteAll(List<MenuItem> menuItemList);
}
