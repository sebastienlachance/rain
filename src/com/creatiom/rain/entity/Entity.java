package com.creatiom.rain.entity;

import java.util.Random;

import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.Sprite;
import com.creatiom.rain.level.Level;

public class Entity {
	
	private boolean removed = false;
	protected Sprite sprite;
	protected final Random random = new Random();
	protected int x, y;
	public Level level;
	
	public Entity() {
		
	}
	
	public Entity(int x, int y, Sprite sprite)  {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
	}
	
	
	public void update() {
	}
	
	public void render(Screen screen) {
		
	}
	
	public void remove() {
		//Remove from level
		removed = true;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	
}
