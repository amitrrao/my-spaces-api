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
 * AssetService is a service class that implements methods to fetch Asset related information.
 * These methods are invoked from a controller.
 * Currently all the data comes from the TestData class. In production, it will come from a database.
 * 
 */
@Service
public class AssetService {

	private static final Logger logger = LoggerFactory.getLogger(AssetService.class);
	
	/**
	 * A method to get all assets for a given spaceId.
	 * 
	 * @param spaceId
	 * @return a list of all Asset instances.
	 */
	public List<Item> getAllAssetsBySpace(String spaceId) {
		logger.info(String.format("Getting all assets with spaceId: %s.", spaceId));
		return TestData.ASSETS;
	}

	/**
	 * A method to get an asset given a spaceId and an assetId.
	 * 
	 * @param spaceId
	 * @param assetId
	 * @return a single Asset instance
	 */
	public Item getAssetBySpaceIdAndAssetId(String spaceId, String assetId) throws ItemNotFoundException {
		
		logger.info(String.format("Getting asset with spaceId: %s and assetId: %s", spaceId, assetId));
		
		try {
			Item asset = TestData.ASSETS.stream().filter(a -> a.getSys()
					.getId()
					.equals(assetId))
					.findFirst()
					.get();
			return asset;
		} catch(NoSuchElementException nsee) {
			throw new ItemNotFoundException(Type.ASSET.getType() + " not found.");
		}
	}
}