package com.exercise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.base.Role;
import com.exercise.builder.UserBuilder;
import com.exercise.item.Item;

/**
 * 
 * UserService is a service class that implements REST methods for User related information.
 *
 */
@Service
public class UserService {
	private List<Item> users = new ArrayList<>(Arrays.asList(
			new UserBuilder("Alana Atlassian", 
					"4FLrUHftHW3v2BLi9fzfjU", 
					Role.AUTHOR).build(),
			new UserBuilder("John Doe", 
					"4FLrUHftHW3v2BLi9fzfjU2",
					Role.EDITOR).build()));
	
	/**
	 * A method to get all users in the system.
	 * 
	 * @return - a list of all User instances.
	 */
	public List<Item> getAllUsers() {
		return users;
	}
	
	/**
	 * A method to get a user given a userId.
	 * 
	 * @param userId
	 * @return a single User instance
	 */
	public Item getUser(String userId) {
		return users.stream().filter(u -> u.getSys()
				.getId()
				.equals(userId))
				.findFirst()
				.get();
	}
}
