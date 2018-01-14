package com.exercise.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.exercise.base.Type;
import com.exercise.data.TestData;
import com.exercise.exceptions.ItemNotFoundException;
import com.exercise.item.Item;

/**
 * 
 * EntryService is a service class that implements REST methods for Entry related information.
 * All the data for this class is coming from TestData. In production, it would ideally come from a database.
 * 
 */
@Service
public class EntryService {

	private static final Logger logger = LoggerFactory.getLogger(EntryService.class);
	
	/**
	 * A method to get all entries for a given spaceId.
	 * 
	 * @param spaceId
	 * @return a list of all Entry instances.
	 */
	public List<Item> getAllEntriesBySpace(String spaceId) {
		logger.info(String.format("Getting all entries with spaceId: %s.", spaceId));
		return TestData.ENTRIES;
	}

	/**
	 * A method to get an entry given a spaceId and an entryId.
	 * 
	 * @param spaceId
	 * @param entryId
	 * @return a single Entry instance
	 */
	public Item getEntryBySpaceIdAndEntryId(String spaceId, String entryId) throws ItemNotFoundException {
		
		logger.info(String.format("Getting entry with spaceId: %s and entryId: %s", spaceId, entryId));
		
		try {
			Item entry = TestData.ENTRIES.stream().filter(e -> e.getSys()
					.getId()
					.equals(entryId))
					.findFirst()
					.get();
			return entry;
		} catch (NoSuchElementException nsee) {
			throw new ItemNotFoundException(Type.ENTRY.getType() + " not found.");
		}
	}
}
