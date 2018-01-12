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
public class EntryService {

	private List<Item> entries = new ArrayList<>(Arrays.asList(
			new Item(new Field("Hello, World!", "A Hello World is a common starting point for learning a new language or platform.", "Body 1"), new Sys(Type.Entry, "5KsDBWseXY6QegucYAoacS1", new Date(), "4FLrUHftHW3v2BLi9fzfjU", new Date(), "4FLrUHftHW3v2BLi9fzfjU")),
			new Item(new Field("Tutorial 1", "In this tutorial, we will dive deeper into how to leverage the new platform.", "Body 1"), new Sys(Type.Entry, "5KsDBWseXY6QegucYAoacS2", new Date(), "4FLrUHftHW3v2BLi9fzfjU", new Date(), "4FLrUHftHW3v2BLi9fzfjU2")),
			new Item(new Field("Tutorial 2", "In this tutorial, we will provide an example deployment.", "Body 1"), new Sys(Type.Entry, "5KsDBWseXY6QegucYAoacS3", new Date(), "4FLrUHftHW3v2BLi9fzfjU", new Date(), "4FLrUHftHW3v2BLi9fzfjU2"))
			));
	
	public List<Item> getAllEntriesBySpace(String spaceId) {
		return entries;
	}
	
	public Item getEntryBySpaceIdAndEntryId(String spaceId, String entryId) {
		return entries.stream().filter(e -> e.getSys()
				.getId()
				.equals(entryId))
				.findFirst()
				.get();
	}
}
