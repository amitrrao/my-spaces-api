package com.exercise.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.exceptions.ItemNotFoundException;
import com.exercise.item.Item;
import com.exercise.service.AssetService;
import com.exercise.service.EntryService;
import com.exercise.service.SpaceService;

/**
 * 
 * This is a Space Controller class that maps incoming REST calls to appropriate service methods.
 * It injects singletons for the service instances and calls methods on them based on the request mapping.
 * 
 */
@RestController
public class SpaceController implements ErrorController {
	
	private static final Logger logger = LoggerFactory.getLogger(SpaceController.class);
	private static final String INVALID_PATH = "/error";
	
	@Autowired
	private SpaceService spaceService;
	@Autowired
	private EntryService entryService;
	@Autowired
	private AssetService assetService;
	
	@RequestMapping("/spaces")
	public List<Item> getAllSpaces() {
		List<Item> spaces = spaceService.getAllSpaces();
		logger.info(String.format("Total number of spaces: %d", spaces.size()));
		return spaces;
	}
	
	@RequestMapping("/spaces/{spaceId}")
	public Item getSpace(@PathVariable(required = true) String spaceId) throws ItemNotFoundException {
		return spaceService.getSpace(spaceId);
	}
	
	@RequestMapping("/spaces/{spaceId}/entries")
	public List<Item> getAllEntriesBySpace(@PathVariable(required = true) String spaceId) throws ItemNotFoundException {
		List<Item> entries = entryService.getAllEntriesBySpace(spaceId);
		logger.info(String.format("Total number of entries: %d", entries.size()));
		return entries;
	}
	
	@RequestMapping("/spaces/{spaceId}/entries/{entryId}")
	public Item getEntryBySpaceIdAndEntryId(@PathVariable(required = true) String spaceId, @PathVariable(required = true) String entryId) throws ItemNotFoundException {
		return entryService.getEntryBySpaceIdAndEntryId(spaceId, entryId);
	}
	
	@RequestMapping("/spaces/{spaceId}/assets")
	public List<Item> getAllAssetsBySpace(@PathVariable(required = true) String spaceId) throws ItemNotFoundException {
		List<Item> assets = assetService.getAllAssetsBySpace(spaceId);
		logger.info(String.format("Total number of assets: %d", assets.size()));
		return assets;
	}
	
	@RequestMapping("/spaces/{spaceId}/assets/{assetId}")
	public Item getAssetBySpaceIdAndAssetId(@PathVariable(required = true) String spaceId, @PathVariable(required = true) String assetId) throws ItemNotFoundException {
		return assetService.getAssetBySpaceIdAndAssetId(spaceId, assetId);
	}

	@RequestMapping(value = INVALID_PATH)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String error() {
		logger.warn("Invalid URL endpoint requested.");
        return "Sorry, this is not a valid REST endpoint.";
    }
	
	@Override
	public String getErrorPath() {
		return INVALID_PATH;
	}
}