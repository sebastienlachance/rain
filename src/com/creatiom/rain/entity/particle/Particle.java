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
	
	protected double xx, yy, zz;
	protected double xa, ya, za;

	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(20) - 10);
		sprite = Sprite.particle_normal;
		this.xa = random.nextGaussian() + 1.8;
		if (this.xa < 0) xa = 0.1;
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat() + 2.0;
	}
	
	public void update() {
		time++;
		if (time > 7400) time = 0;
		if (time > life) remove();
		za -= 0.1;
		
		if (zz < 0) {
			zz = 0;
			za *= -0.55;
			xa *= 0.4;
			ya *= 0.4;
		}
		
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx - 10, (int)yy - (int)zz, this.sprite, true);
	}
	
	private boolean collision(double xa, double ya) {
		boolean solid = false;
		for(int c = 0; c < 4; c++) {
			double xt = ((xx + xa) + c % 2 * sprite.getWidth()) / 16;
			double yt = ((yy - (int)zz + ya) + c / 2 * sprite.getHeight()) / 16;
			if (level.getTile((int)xt, (int)yt).solid()) solid = true;
		}
		return solid;
	}
	
}
