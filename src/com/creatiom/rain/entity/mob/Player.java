package com.creatiom.rain.entity.mob;

import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.Sprite;
import com.creatiom.rain.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_forward;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
	} 
	
	public void update() {
		int xa = 0, ya = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) move(xa, ya);
	}
	
	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) sprite = Sprite.player_forward;
		if (dir == 1) sprite = Sprite.player_side;
		if (dir == 2) sprite = Sprite.player_back;
		if (dir == 3) {
			flip = 1;
			sprite = Sprite.player_side;
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
	
}
