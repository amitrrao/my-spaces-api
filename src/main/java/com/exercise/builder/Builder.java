package com.exercise.builder;

import com.exercise.item.Item;

/**
 * 
 * The Builder interface that all builder type classes must implement.
 *
 */

//TODO: This could be a functional interface because it has only one abstract method.
public interface Builder {
	
	public Item build();
}
