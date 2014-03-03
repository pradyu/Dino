package com.dino.controller;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.dino.entity.Restaurant;
import com.dino.repo.AbstractTest;
import com.dino.rest.entity.LocuVenueResource;
import com.dino.rest.entity.RestaurantResource;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@ComponentScan("com.dino.service")
@ActiveProfiles("test")
public class RestaurantControllerTest extends AbstractTest {

	private static ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private WebApplicationContext ctx;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		super.setup();
		mockMvc = MockMvcBuilders
				.<StandaloneMockMvcBuilder> webAppContextSetup(ctx).build();
	}

	@Test
	public void canCreateAndGetRestaurant() throws Exception {
		 Restaurant restaurant = new Restaurant("test");
		MvcResult result = mockMvc
					.perform(
							post("/restaurant")
							.accept(MediaType.APPLICATION_JSON)
							.contentType(MediaType.APPLICATION_JSON)
							.content(
									objectMapper
									.writeValueAsString(restaurant)))
									.andExpect(status().isCreated()).andReturn();

			String location = result.getResponse().getHeader("location");
			assertNotNull(location);

			result = mockMvc
					.perform(get(location).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();

			String content = result.getResponse().getContentAsString();
			assertNotNull(content);
			RestaurantResource response = objectMapper.readValue(content,
					RestaurantResource.class);
			assertNotNull(response);
			assertEquals(restaurant.getName(), response.getRestaurant()
					.getName());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSearchRestaurant() throws Exception{
		MvcResult result = mockMvc
				.perform(get("/search?name=jose+tejas&locality=new+york").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		assertEquals(result.getResponse().getStatus(), 200);
		result = mockMvc
				.perform(get("/search?name=jose+tejas").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		assertEquals(result.getResponse().getStatus(), 400);
		result = mockMvc
				.perform(get("/search").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		assertEquals(result.getResponse().getStatus(), 400);
	}
	
}