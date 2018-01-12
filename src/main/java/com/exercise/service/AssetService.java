package com.exercise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exercise.base.Field;
import com.exercise.base.Sys;
import com.exercise.base.Type;
import com.exercise.item.Item;

@Service
public class AssetService {

	private List<Item> assets = new ArrayList<>(Arrays.asList(
			new Item(new Field("Hero Collaboration Partial", "image/png", "hero-collaboration-partial.png","https://wac-cdn.atlassian.com/dam/jcr:51be4df5-1ffb-4a4d-9f44-0b84dad9de5e/hero-collaboration-partial.png"), new Sys(Type.Asset, "wtrHxeu3zEoEce2MokCSi1", new Date(), "4FLrUHftHW3v2BLi9fzfjU", new Date(), "4FLrUHftHW3v2BLi9fzfjU")),
			new Item(new Field("Stride Chat", "image/png", "stride_chat.svg","https://wac-cdn.atlassian.com/dam/jcr:61741d76-b9a0-44b1-a31f-bfde8e6930ab/stride_chat.svg"), new Sys(Type.Asset, "wtrHxeu3zEoEce2MokCSi2", new Date(), "4FLrUHftHW3v2BLi9fzfjU", new Date(), "4FLrUHftHW3v2BLi9fzfjU")),
			new Item(new Field("Get Started", "image/png", "getstarted-collab.png","getstarted-collab.png"), new Sys(Type.Asset, "wtrHxeu3zEoEce2MokCSi3", new Date(), "4FLrUHftHW3v2BLi9fzfjU2", new Date(), "4FLrUHftHW3v2BLi9fzfjU2"))
			));
	
	public List<Item> getAllAssetsBySpace(String spaceId) {
		return assets;
	}
	
	public Item getAssetBySpaceIdAndAssetId(String spaceId, String assetId) {
		return assets.stream().filter(a -> a.getSys()
				.getId()
				.equals(assetId))
				.findFirst()
				.get();
	}
}