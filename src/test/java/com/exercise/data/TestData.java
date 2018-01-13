package com.exercise.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.exercise.base.Role;
import com.exercise.builder.AssetBuilder;
import com.exercise.builder.EntryBuilder;
import com.exercise.builder.SpaceBuilder;
import com.exercise.builder.UserBuilder;
import com.exercise.item.Item;

public class TestData {
	
	/**
	 * Test data for Spaces.
	 */
	public static final Item SPACE1 = new SpaceBuilder(
			"My First Space", 
			"This space was created by Alanna Atlassian as an example of how to create a space and relate assets and entries to it.", 
			"yadj1kx9rmg0", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU").build();
	public static final Item SPACE2 = new SpaceBuilder(
			"My Second Space",
			"",
			"yadj1kx9rmg01",
			new Date(),
			"4FLrUHftHW3v2BLi9fzfjU",
			new Date(),
			"4FLrUHftHW3v2BLi9fzfjU").build();
	public static final Item SPACE3 = new SpaceBuilder(
			"My Third Space",
			"",
			"yadj1kx9rmg02",
			new Date(),
			"4FLrUHftHW3v2BLi9fzfjU",
			new Date(),
			"4FLrUHftHW3v2BLi9fzfjU").build();
	public static final List<Item> SPACES = new ArrayList<>(Arrays.asList(SPACE1, SPACE2, SPACE3));
	
	/**
	 * Test data for Entries.
	 */
	public static final Item ENTRY1 =  new EntryBuilder(
			"Hello, World!", 
			"A Hello World is a common starting point for learning a new language or platform.", 
			"Body 1", 
			"5KsDBWseXY6QegucYAoacS1", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU",
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU").build();
	public static final Item ENTRY2 = new EntryBuilder(
			"Tutorial 1", 
			"In this tutorial, we will dive deeper into how to leverage the new platform.", 
			"Body 2", 
			"5KsDBWseXY6QegucYAoacS2", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU",
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU2").build();
	public static final Item ENTRY3 = new EntryBuilder(
			"Tutorial 2", 
			"In this tutorial, we will provide an example deployment.", 
			"Body 3", 
			"5KsDBWseXY6QegucYAoacS3", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU",
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU2").build();
	public static final List<Item> ENTRIES = new ArrayList<>(Arrays.asList(ENTRY1, ENTRY2, ENTRY3));
	
	/**
	 * Test data for Assets.
	 */
	public static final Item ASSET1 = new AssetBuilder(
			"Hero Collaboration Partial", 
			"image/png",
			"hero-collaboration-partial.png", 
			"https://wac-cdn.atlassian.com/dam/jcr:51be4df5-1ffb-4a4d-9f44-0b84dad9de5e/hero-collaboration-partial.png", 
			"wtrHxeu3zEoEce2MokCSi1", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU").build();
	public static final Item ASSET2 = new AssetBuilder(
			"Stride Chat", 
			"image/png",
			"stride_chat.svg", 
			"https://wac-cdn.atlassian.com/dam/jcr:61741d76-b9a0-44b1-a31f-bfde8e6930ab/stride_chat.svg", 
			"wtrHxeu3zEoEce2MokCSi2", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU").build();
	public static final Item ASSET3 = new AssetBuilder(
			"Get Started", 
			"image/png",
			"getstarted-collab.png", 
			"https://wac-cdn.atlassian.com/dam/jcr:c7bdc391-e84f-43fe-9e8b-194d8a3b9aaf/getstarted-collab.png", 
			"wtrHxeu3zEoEce2MokCSi3", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU2", 
			new Date(), 
			"4FLrUHftHW3v2BLi9fzfjU2").build();
	public static final List<Item> ASSETS = new ArrayList<>(Arrays.asList(ASSET1, ASSET2, ASSET3));
	
	/**
	 * Test data for Users.
	 */
	public static final Item USER1 = new UserBuilder("Alana Atlassian", 
			"4FLrUHftHW3v2BLi9fzfjU", 
			Role.AUTHOR).build();
	public static final Item USER2 = new UserBuilder("John Doe", 
			"4FLrUHftHW3v2BLi9fzfjU2",
			Role.EDITOR).build();
	public static final List<Item> USERS = new ArrayList<>(Arrays.asList(USER1, USER2));
	
}
