package com.exercise.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.item.Item;
import com.exercise.service.AssetService;
import com.exercise.service.EntryService;
import com.exercise.service.SpaceService;
import com.exercise.service.UserService;

/**
 * 
 * This is our Controller class that maps incoming REST calls to appropriate service methods.
 * It injects singletons for the service instances and calls methods on them based on the request mapping.
 * 
 */
@RestController
public class SpaceController { //implements ErrorController {

	//private static final String INVALID_PATH = "/error";
	@Autowired
	private SpaceService spaceService;
	@Autowired
	private EntryService entryService;
	@Autowired
	private AssetService assetService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/spaces")
	public List<Item> getAllSpaces() {
		final Logger logger = LoggerFactory.getLogger(SpaceController.class);
		logger.info("Getting all spaces");
		return spaceService.getAllSpaces();
	}
	
	@RequestMapping("/spaces/{spaceId}")
	public Item getSpace(@PathVariable(required = true) String spaceId) {
		return spaceService.getSpace(spaceId);
	}
	
	@RequestMapping("/spaces/{spaceId}/entries")
	public List<Item> getAllEntriesBySpace(@PathVariable(required = true) String spaceId) {
		return entryService.getAllEntriesBySpace(spaceId);
	}
	
	@RequestMapping("/spaces/{spaceId}/entries/{entryId}")
	public Item getEntryBySpaceIdAndEntryId(@PathVariable(required = true) String spaceId, @PathVariable(required = true) String entryId) {
		return entryService.getEntryBySpaceIdAndEntryId(spaceId, entryId);
	}
	
	@RequestMapping("/spaces/{spaceId}/assets")
	public List<Item> getAllAssetsBySpace(@PathVariable(required = true) String spaceId) {
		return assetService.getAllAssetsBySpace(spaceId);
	}
	
	@RequestMapping("/spaces/{spaceId}/assets/{assetId}")
	public Item getAssetBySpaceIdAndAssetId(@PathVariable(required = true) String spaceId, @PathVariable(required = true) String assetId) {
		return assetService.getAssetBySpaceIdAndAssetId(spaceId, assetId);
	}
	
	@RequestMapping("/users")
	public List<Item> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{userId}")
	public Item getUser(@PathVariable(required = true) String userId) {
		return userService.getUser(userId);
	}

//	@RequestMapping(value = INVALID_PATH)
//    public String error() {
//        return "Sorry, this is not a valid REST endpoint.";
//    }
//	
//	@Override
//	public String getErrorPath() {
//		return INVALID_PATH;
//	}
}