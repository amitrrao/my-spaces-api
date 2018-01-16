package com.exercise.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.base.Type;
import com.exercise.data.TestData;
import com.exercise.exceptions.ItemNotFoundException;
import com.exercise.item.Item;

/**
 * 
 * EntryService is a service class that implements methods to fetch Entry related information.
 * These methods are invoked from a controller.
 * Currently all the data comes from the TestData class. In production, it will come from a database.
 * 
 */

@Service
public class EntryService {

	private static final Logger logger = LoggerFactory.getLogger(EntryService.class);

	@Autowired
	private SpaceService spaceService;

	/**
	 * A method to get all entries for a given spaceId.
	 * 
	 * @param spaceId
	 * @return a list of all Entry instances.
	 * @throws ItemNotFoundException - If the given spaceId is not found.
	 */
	public List<Item> getAllEntriesBySpace(String spaceId) throws ItemNotFoundException {
		logger.info(String.format("Getting all entries with spaceId: %s.", spaceId));

		if (spaceService.isValidSpaceId(spaceId)) {
			return TestData.ENTRIES;
		} else {
			throw new ItemNotFoundException(String.format("%s with id %s not found.", Type.SPACE.getType(), spaceId));	
		}
	}

	/**
	 * A method to get an entry given a spaceId and an entryId.
	 * 
	 * @param spaceId
	 * @param entryId
	 * @return a single Entry instance
	 * @throws ItemNotFoundException - If the given spaceId is not found.
	 */
	public Item getEntryBySpaceIdAndEntryId(String spaceId, String entryId) throws ItemNotFoundException {

		logger.info(String.format("Getting entry with spaceId: %s and entryId: %s", spaceId, entryId));

		try {
			if (spaceService.isValidSpaceId(spaceId)) {
				Item entry = TestData.ENTRIES.stream().filter(e -> e.getSys()
						.getId()
						.equals(entryId))
						.findFirst()
						.get();
				return entry;
			} else {
				throw new ItemNotFoundException(String.format("%s with id %s not found.", Type.SPACE.getType(), spaceId));
			}
		} catch (NoSuchElementException nsee) {
			throw new ItemNotFoundException(String.format("%s not found.", Type.ENTRY.getType()));
		}
	}
}
