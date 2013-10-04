package com.creatiom.rain.entity.spawner;

import com.creatiom.rain.entity.particle.Particle;
import com.creatiom.rain.level.Level;

public class ParticleSpawner extends Spawner {

	private int life;

	public ParticleSpawner(int x, int y, int life, int amount, Level level) {
		super(x, y, Type.PARTICLE, amount, level);
		this.life = life;
		for(int i = 0; i < amount; i++) {
			level.add(new Particle(x, y, life));
		}
	}
	
	
}
