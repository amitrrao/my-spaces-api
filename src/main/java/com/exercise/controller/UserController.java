package com.exercise.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.exceptions.ItemNotFoundException;
import com.exercise.item.Item;
import com.exercise.service.UserService;

/**
 * 
 * This is a User Controller class that maps incoming REST calls to appropriate User service methods.
 * It injects a userService singleton for the service instances and calls methods on them based on the request mapping.
 * 
 * @author arao
 */
@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public List<Item> getAllUsers() {
		List<Item> users = userService.getAllUsers();
		logger.info(String.format("Total number of users: %d", users.size()));
		return users;
	}
	
	@RequestMapping("/users/{userId}")
	public Item getUser(@PathVariable(required = true) String userId) throws ItemNotFoundException {
		return userService.getUser(userId);
	}
}
