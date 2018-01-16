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
 * SpaceService is a service class that implements methods to fetch Space related information.
 * These methods are invoked from a controller.
 * Currently all the data comes from the TestData class. In production, it will come from a database.
 * 
 */

@Service
public class SpaceService {
	
	private static final Logger logger = LoggerFactory.getLogger(SpaceService.class);

	/**
	 * A method to get all spaces in the system
	 * 
	 * @return a list of all Space instances
	 */
	public List<Item> getAllSpaces() {
		logger.info("Getting all spaces:");
		return TestData.SPACES;
	}

	/**
	 * A method to get a space given a spaceId.
	 * 
	 * @param spaceId
	 * @return a single Space instance
	 */
	public Item getSpace(String spaceId) throws ItemNotFoundException {
		
		logger.info(String.format("Getting space with id: %s", spaceId));
		
		try {
			Item space = TestData.SPACES.stream().filter(s -> s.getSys()
					.getId()
					.equals(spaceId))
					.findFirst()
					.get();
			return space;
		} catch (NoSuchElementException nsee) {
			throw new ItemNotFoundException(Type.SPACE.getType() + " not found.");
		}
	}
	
	public boolean isValidSpaceId(String spaceId) {
		return TestData.SPACES.stream().filter(s -> s.getSys().getId().equals(spaceId)).count() == 1;
	}
}