package com.creatiom.rain.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.creatiom.rain.entity.Entity;
import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.Sprite;

public class Particle extends Entity {

	private Sprite sprite;
	
	private int life;
	private int time = 0;
	
	protected double xx, yy, xa, ya;

	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(20) - 10);
		sprite = Sprite.particle_normal;
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
	}
	
	public void update() {
		time++;
		if (time > 7400) time = 0;
		if (time > life) remove();
		if (!collision((int)xa, (int)ya)) {
			this.xx += xa;
			this.yy += ya;
		} 
	
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy, this.sprite, true);
	}
	
	private boolean collision(double xa, double ya) {
		boolean solid = false;
		for(int c = 0; c < 4; c++) {
			double xt = ((xx + xa) + c % 2 * sprite.getWidth()) / 16;
			double yt = ((yy + ya) + c / 2 * sprite.getHeight()) / 16;
			if (level.getTile((int)xt, (int)yt).solid()) solid = true;
		}
		return solid;
	}
	
}
