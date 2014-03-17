package com.dino.repo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;

import com.dino.entity.Menu;

@ActiveProfiles("test")
public class MenuRepositoryImplTest extends AbstractTest {

    @Autowired
    @Qualifier("menuRepository")
    MenuRepository menuRepository;

    @Test
    public void canSaveMenu() {
        Menu menu = new Menu();
        menu.setRestaurantId("abcdefghijkl");
        Menu retVal = menuRepository.save(menu);
        assertNotNull(retVal);
    }

    @Test
    public void canGetMenuByRestaurant() {
    	String restaurantId = "abcdefghijkl";
        Menu menu = new Menu();
        menuRepository.save(menu);
        List<Menu> retVal = menuRepository.getMenuListByRestaurant(restaurantId);
        assertNotNull(retVal);
    }
    
    @Test
    public void canGetMenuById() {
        Menu menu = new Menu();
        menu.setRestaurantId("123456789");
        Menu savedMenu = menuRepository.save(menu);
        Menu retVal = menuRepository.getMenu(savedMenu.getId());
        assertTrue(savedMenu.getRestaurantId().equals(retVal.getRestaurantId()));
    }

    @Test
    public void canGetAllMenus() {
        menuRepository.save(new Menu());
        menuRepository.save(new Menu());
        List<Menu> retVal = menuRepository.findAll();
        assertNotNull(retVal);
        assertTrue(retVal.size() > 1);
    }
}
