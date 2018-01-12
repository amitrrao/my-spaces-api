package com.exercise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.base.Field;
import com.exercise.base.Sys;
import com.exercise.base.Type;
import com.exercise.item.Item;

@Service
public class SpaceService {

	private List<Item> spaces = new ArrayList<>(Arrays.asList(
			new Item(new Field("My First Space", "This space was created by Alanna Atlassian as an example of how to create a space and relate assets and entries to it."), new Sys(Type.Space, "yadj1kx9rmg0", new Date(), "4FLrUHftHW3v2BLi9fzfjU", new Date(), "4FLrUHftHW3v2BLi9fzfjU")),
			new Item(new Field("My Second Space", ""), new Sys(Type.Space, "yadj1kx9rmg01", new Date(), "4FLrUHftHW3v2BLi9fzfjU", new Date(), "4FLrUHftHW3v2BLi9fzfjU")),
			new Item(new Field("My Third Space", ""), new Sys(Type.Space, "yadj1kx9rmg02", new Date(), "4FLrUHftHW3v2BLi9fzfjU", new Date(), "4FLrUHftHW3v2BLi9fzfjU"))
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