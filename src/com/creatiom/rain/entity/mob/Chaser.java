package com.creatiom.rain.entity.mob;

import com.creatiom.rain.graphics.AnimatedSprite;
import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.SpriteSheet;

public class Chaser extends Mob {

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 32, 32, 3);
	
	private AnimatedSprite animSprite = down;
	
	private int xa = 0;
	private int ya = 0;
	private int time = 0;
	
	public Chaser(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		this.sprite = animSprite.getSprite();
	}

	public void update() {
		time++; //60 times per seconds
		
		if (time % (random.nextInt(50) + 30) == 0) { // = happens once per 1 second
			xa = random.nextInt(3) - 1;
			ya = random.nextInt(3) - 1;
			if (random.nextInt(4) == 0) {
				xa = 0;
				ya = 0;
			}
		}
		
		
		
		//Basic AI
		
		if (walking) animSprite.update();
		else animSprite.setFrame(0);
		
		if (ya < 0) {
			animSprite = up;
			dir = Direction.UP;
		} else if (ya > 0) {
			animSprite = down;
			dir = Direction.DOWN;
		}
		
		if (xa < 0) {
			animSprite = left;
			dir = Direction.LEFT;
		} else if (xa > 0) {
			animSprite = right;
			dir = Direction.RIGHT;
		}
		
		
		if (xa != 0 || ya != 0) {
			move(xa, ya); 
			walking = true;
		} 
		else { 
			walking = false;
		}
	}


	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob(x, y , this);
	}

}
