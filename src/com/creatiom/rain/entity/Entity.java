package com.creatiom.rain.entity;

import java.util.Random;

import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.level.Level;

public class Entity {
	
	private boolean removed = false;
	protected final Random random = new Random();
	public int x, y;
	public Level level;
	
	
	public void update() {
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		//Remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
}
