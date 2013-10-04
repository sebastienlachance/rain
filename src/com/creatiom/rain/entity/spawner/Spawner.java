package com.creatiom.rain.entity.spawner;

import com.creatiom.rain.entity.Entity;
import com.creatiom.rain.entity.particle.Particle;
import com.creatiom.rain.level.Level;

public class Spawner extends Entity {
	
	public enum Type {
		MOB, 
		PARTICLE
	}
	
	private Type type;
	
	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
		
	}

}