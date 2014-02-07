package com.dino.controller;

import com.dino.ApplicationConfig;
import com.dino.entity.Restaurant;
import com.dino.rest.entity.RestaurantResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
public class RestaurantControllerTest {

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private WebApplicationContext ctx;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.<StandaloneMockMvcBuilder>webAppContextSetup(ctx).build();
    }

    @Test
    public void canCreateRestaurant() throws Exception {
        Restaurant restaurant = new Restaurant("test");
        MvcResult result = mockMvc.perform(
                post("/restaurant")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(restaurant)))
                .andExpect(status().isCreated())
                .andReturn();

        String location = result.getResponse().getHeader("location");
        assertNotNull(location);

        result = mockMvc.perform(
                get(location)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertNotNull(content);
        RestaurantResource response = objectMapper.readValue(content, RestaurantResource.class);
        assertNotNull(response);
        assertEquals(restaurant.getName(), response.getRestaurant().getName());
    }
}
