package com.exercise.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.exercise.base.Type;
import com.exercise.data.TestData;
import com.exercise.exceptions.ItemNotFoundException;
import com.exercise.item.Item;

/**
 * 
 * SpaceService is a service class that implements REST methods for Space related information.
 * All the data for this class is coming from TestData. In production, it would ideally come from a database.
 * 
 */
@Service
public class SpaceService {

	/**
	 * A method to get all spaces in the system
	 * 
	 * @return a list of all Space instances
	 */
	public List<Item> getAllSpaces() {
		return TestData.SPACES;
	}

	/**
	 * A method to get a space given a spaceId.
	 * 
	 * @param spaceId
	 * @return a single Space instance
	 */
	public Item getSpace(String spaceId) throws ItemNotFoundException {
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
}