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
        Menu menu = new Menu("menu1");
        Menu retVal = menuRepository.save(menu);
        assertNotNull(retVal);
    }

    @Test
    public void canGetMenuByRestaurantName() {
        Menu menu = new Menu("sampleRestaurant");
        menuRepository.save(menu);
        Menu retVal = menuRepository.getMenuByRestaurant("sampleRestaurant");
        assertNotNull(retVal);
    }
    
    @Test
    public void canGetMenuById() {
        Menu menu = new Menu("sampleRestaurant");
        Menu savedMenu = menuRepository.save(menu);
        Menu retVal = menuRepository.getMenu(savedMenu.getId());
        assertTrue(savedMenu.equals(retVal));
    }

    @Test
    public void canGetAllMenus() {
        menuRepository.save(new Menu("menu1"));
        menuRepository.save(new Menu("menu2"));
        List<Menu> retVal = menuRepository.findAll();
        assertNotNull(retVal);
        assertTrue(retVal.size() > 1);
    }
}
