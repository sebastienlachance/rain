package com.creatiom.rain.entity.mob;

import com.creatiom.rain.entity.Entity;
import com.creatiom.rain.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move() {
	}
	
	public void update() {	
	}
	
	private boolean collision() {
		return false;
	}
	
	public void render() {
	}
	
}
