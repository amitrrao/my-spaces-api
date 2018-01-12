package com.exercise.item;

import com.exercise.base.Field;
import com.exercise.base.Sys;

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

	public Item() {
		
	}
}
