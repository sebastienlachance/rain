package com.creatiom.rain.entity.mob;

import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.Sprite;

public class Dummy extends Mob {

	public Dummy(int x, int y) {
		this.x = x << 4; // * 16
		this.y = y << 4; // * 16
		sprite = Sprite.player_forward;
	}
	
	public void update() {
	}

	public void render(Screen screen) {
		screen.renderMob(x, y , sprite, 0);
	}

}
