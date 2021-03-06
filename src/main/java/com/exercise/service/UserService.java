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
 * UserService is a service class that implements methods to fetch User related information.
 * These methods are invoked from a controller.
 * Currently all the data comes from the TestData class. In production, it will come from a database.
 * 
 * @author arao
 */
@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	/**
	 * A method to get all users in the system.
	 * 
	 * @return - a list of all User instances.
	 */
	public List<Item> getAllUsers() {
		logger.info("Getting all users:");
		return TestData.USERS;
	}

	/**
	 * A method to get a user given a userId.
	 * 
	 * @param userId
	 * @return a single User instance
	 */
	public Item getUser(String userId) throws ItemNotFoundException {
		
		logger.info(String.format("Getting user with id: %s", userId));
		
		try {
			Item user =  TestData.USERS.stream().filter(u -> u.getSys()
					.getId()
					.equals(userId))
					.findFirst()
					.get();
			return user;
		} catch(NoSuchElementException nsee) {
			throw new ItemNotFoundException(Type.USER.getType() + " not found.");
		}
	}
}
