package com.dino.controller;

import com.dino.ApplicationConfig;
import com.dino.entity.Restaurant;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
@Ignore
public class RestaurantControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        //mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void canCreateRestaurant() throws Exception {
        Restaurant restaurant = new Restaurant("test");
        mockMvc.perform(post("/restaurant").accept(MediaType.APPLICATION_JSON));
    }
    @Test
    public void canGetRestaurants() throws Exception {
        Restaurant restaurant = new Restaurant("test");
        mockMvc.perform(post("/restaurant").accept(MediaType.APPLICATION_JSON));
    }

}
