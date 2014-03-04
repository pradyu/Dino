package com.dino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dino.entity.LocuVenue;

@Service("locuSearchService")
public interface LocuSearchService {
	List<LocuVenue> findRestaurants(String name, String locality);
}
