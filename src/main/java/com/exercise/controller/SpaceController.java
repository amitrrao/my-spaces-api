package com.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.item.Item;
import com.exercise.service.AssetService;
import com.exercise.service.EntryService;
import com.exercise.service.SpaceService;
import com.fasterxml.jackson.annotation.JsonInclude;

@RestController
public class SpaceController {

	@Autowired
	private SpaceService spaceService;
	
	@Autowired
	private EntryService entryService;
	
	@Autowired
	private AssetService assetService;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@RequestMapping("/spaces")
	public List<Item> getAllSpaces() {
		return spaceService.getAllSpaces();
	}
	
	@RequestMapping("/spaces/{spaceId}")
	public Item getSpace(@PathVariable String spaceId) {
		return spaceService.getSpace(spaceId);
	}
	
	@RequestMapping("/spaces/{spaceId}/entries")
	public List<Item> getAllEntriesBySpace(@PathVariable String spaceId) {
		return entryService.getAllEntriesBySpace(spaceId);
	}
	
	@RequestMapping("/spaces/{spaceId}/entries/{entryId}")
	public Item getEntryBySpaceIdAndEntryId(@PathVariable String spaceId, @PathVariable String entryId) {
		return entryService.getEntryBySpaceIdAndEntryId(spaceId, entryId);
	}
	
	@RequestMapping("/spaces/{spaceId}/assets")
	public List<Item> getAllAssetsBySpace(@PathVariable String spaceId) {
		return assetService.getAllAssetsBySpace(spaceId);
	}
	
	@RequestMapping("/spaces/{spaceId}/assets/{assetId}")
	public Item getAssetBySpaceIdAndAssetId(@PathVariable String spaceId, @PathVariable String assetId) {
		return assetService.getAssetBySpaceIdAndAssetId(spaceId, assetId);
	}

//	public ResponseEntity<Object> getErrorMessage() {
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	}
}