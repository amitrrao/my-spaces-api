package com.exercise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.builder.EntryBuilder;
import com.exercise.item.Item;

/**
 * 
 * EntryService is a service class that implements REST methods for Entry related information.
 *
 */
@Service
public class EntryService {
	
	private List<Item> entries = new ArrayList<>(Arrays.asList(
			new EntryBuilder(
					"Hello, World!", 
					"A Hello World is a common starting point for learning a new language or platform.", 
					"Body 1", 
					"5KsDBWseXY6QegucYAoacS1", 
					new Date(), 
					"4FLrUHftHW3v2BLi9fzfjU",
					new Date(), 
					"4FLrUHftHW3v2BLi9fzfjU").build(),
			new EntryBuilder(
					"Tutorial 1", 
					"In this tutorial, we will dive deeper into how to leverage the new platform.", 
					"Body 2", 
					"5KsDBWseXY6QegucYAoacS2", 
					new Date(), 
					"4FLrUHftHW3v2BLi9fzfjU",
					new Date(), 
					"4FLrUHftHW3v2BLi9fzfjU2").build(),
			new EntryBuilder(
					"Tutorial 2", 
					"In this tutorial, we will provide an example deployment.", 
					"Body 3", 
					"5KsDBWseXY6QegucYAoacS3", 
					new Date(), 
					"4FLrUHftHW3v2BLi9fzfjU",
					new Date(), 
					"4FLrUHftHW3v2BLi9fzfjU2").build()
			));
	
	/**
	 * A method to get all entries for a given spaceId.
	 * 
	 * @param spaceId
	 * @return a list of all Entry instances.
	 */
	public List<Item> getAllEntriesBySpace(String spaceId) {
		return entries;
	}
	
	/**
	 * A method to get an entry given a spaceId and an entryId.
	 * 
	 * @param spaceId
	 * @param entryId
	 * @return a single Entry instance
	 */
	public Item getEntryBySpaceIdAndEntryId(String spaceId, String entryId) {
		return entries.stream().filter(e -> e.getSys()
				.getId()
				.equals(entryId))
				.findFirst()
				.get();
	}
}
