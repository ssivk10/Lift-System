package com.zsgs.liftsystem.models;

import java.util.ArrayList;
import java.util.List;

public class Lift {
	private String name;
	private int current;
	
	private int capacity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}

	/*
	 * public int getFrom() { return from; } public void setFrom(int from) {
	 * this.from = from; } public int getTo() { return to; } public void setTo(int
	 * to) { this.to = to; }
	 */
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
