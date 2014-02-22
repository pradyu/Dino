package com.dino.controller;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.dino.entity.Menu;
import com.dino.repo.AbstractTest;
import com.dino.rest.entity.MenuResource;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@ActiveProfiles("test")
public class MenuControllerTest extends AbstractTest{

    private static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private WebApplicationContext ctx;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        super.setup();
        mockMvc = MockMvcBuilders.<StandaloneMockMvcBuilder>webAppContextSetup(ctx).build();
    }

    @Test
    public void canCreateAndGetMenu() throws Exception {
        Menu menu = new Menu("test");
        MvcResult result = mockMvc.perform(
                post("/restaurant/{id}/menu", "test")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(menu)
                        ))
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
        MenuResource response = objectMapper.readValue(content, MenuResource.class);
        assertNotNull(response);
        assertEquals(menu.getRestaurantId(), response.getMenu().getRestaurantId());
    }
}
