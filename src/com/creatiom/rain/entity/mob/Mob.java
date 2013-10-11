package com.creatiom.rain.entity.mob;

import com.creatiom.rain.entity.Entity;
import com.creatiom.rain.entity.projectile.Projectile;
import com.creatiom.rain.entity.projectile.WizardProjectile;
import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.Sprite;

public abstract class Mob extends Entity {
	
	protected boolean moving = false;
	protected boolean walking = false;
	
	protected enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	protected Direction dir;
	
	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if (xa > 0) dir = Direction.RIGHT;
		if (xa < 0) dir = Direction.LEFT;
		if (ya > 0) dir = Direction.DOWN;
		if (ya < 0) dir = Direction.UP;
			
		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		} 
	}
	
	public abstract void update();
	
	public abstract void render(Screen screen);
	
	protected void shoot(int x, int y, double dir) {
		Projectile p = new WizardProjectile(x, y, dir);
		level.add(p);
	}
	
	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for(int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 14 - 8) / 16;
			int yt = ((y + ya) + c / 2 * 12 + 3) / 16;
			if (level.getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}
	

}
