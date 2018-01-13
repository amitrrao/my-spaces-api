package com.exercise.item;

import com.exercise.base.Field;
import com.exercise.base.Sys;

/**
 * 
 * This is an Item class that represents a generic 'Item' instance.
 * Depending on the caller, today, it could be either a Space, an Entry, an Asset or a User item.
 * This makes it easy to add a new type by writing a new builder.
 *
 */
public class Item {
	private Field fields;
	private Sys sys;
	
	public Item(Field fields, Sys sys) {
		this.fields = fields;
		this.sys = sys;
	}

	public Field getFields() {
		return fields;
	}

	public void setFields(Field fields) {
		this.fields = fields;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}
}
