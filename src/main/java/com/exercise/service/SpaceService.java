package com.exercise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.builder.SpaceBuilder;
import com.exercise.item.Item;

@Service
public class SpaceService {

	private List<Item> spaces = new ArrayList<>(Arrays.asList(
			new SpaceBuilder(
					"My First Space", 
					"This space was created by Alanna Atlassian as an example of how to create a space and relate assets and entries to it.", 
					"yadj1kx9rmg0", 
					new Date(), 
					"4FLrUHftHW3v2BLi9fzfjU", 
					new Date(), 
					"4FLrUHftHW3v2BLi9fzfjU").build(),
			new SpaceBuilder(
					"My Second Space",
					"",
					"yadj1kx9rmg01",
					new Date(),
					"4FLrUHftHW3v2BLi9fzfjU",
					new Date(),
					"4FLrUHftHW3v2BLi9fzfjU").build(),
			new SpaceBuilder(
					"My Third Space",
					"",
					"yadj1kx9rmg02",
					new Date(),
					"4FLrUHftHW3v2BLi9fzfjU",
					new Date(),
					"4FLrUHftHW3v2BLi9fzfjU").build()
			));
	
	public List<Item> getAllSpaces() {
		return spaces;
	}
	
	public Item getSpace(String spaceId) {
		return spaces.stream().filter(s -> s.getSys()
				.getId()
				.equals(spaceId))
				.findFirst()
				.get();
	}
}