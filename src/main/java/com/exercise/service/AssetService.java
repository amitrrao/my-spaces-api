package com.exercise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.data.TestData;
import com.exercise.item.Item;

/**
 * 
 * AssetService is a service class that implements REST methods for Asset related information.
 * All the data for this class is coming from TestDataOld. In production, it would ideally come from a database.
 * 
 */
@Service
public class AssetService {

	/**
	 * A method to get all assets for a given spaceId.
	 * 
	 * @param spaceId
	 * @return a list of all Asset instances.
	 */
	public List<Item> getAllAssetsBySpace(String spaceId) {
		return TestData.ASSETS;
	}
	
	/**
	 * A method to get an asset given a spaceId and an assetId.
	 * 
	 * @param spaceId
	 * @param assetId
	 * @return a single Asset instance
	 */
	public Item getAssetBySpaceIdAndAssetId(String spaceId, String assetId) {
		return TestData.ASSETS.stream().filter(a -> a.getSys()
				.getId()
				.equals(assetId))
				.findFirst()
				.get();
	}
}