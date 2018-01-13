package com.exercise.builder;

import com.exercise.item.Item;

//TODO: This could be a functional interface because it has only one abstract method.
public interface Builder {
	
	public Item build();
}
