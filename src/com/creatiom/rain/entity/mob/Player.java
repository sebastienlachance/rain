package com.creatiom.rain.entity.mob;

import com.creatiom.rain.Game;
import com.creatiom.rain.entity.projectile.Projectile;
import com.creatiom.rain.entity.projectile.WizardProjectile;
import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.Sprite;
import com.creatiom.rain.input.Keyboard;
import com.creatiom.rain.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	private int speed = 2;
	
	private int fireRate = 0;
	
	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_forward;
	}
	
	public Player(int x, int y, Keyboard input) {
		
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
		fireRate = WizardProjectile.FIRE_RATE;
	} 
	
	public void update() {
		if (fireRate > 0) fireRate--; 
		int xa = 0, ya = 0;
		if (anim < 7500) anim++;
		else anim = 0;
		if (input.up) ya -= speed;
		if (input.down) ya += speed;
		if (input.left) xa -= speed;
		if (input.right) xa += speed;
		
		if (xa != 0 || ya != 0) {
			move(xa, ya); 
			walking = true;
		} 
		else { 
			walking = false;
		}
		
		clear();
		updateShooting();
	}
	
	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}
	}
	
	private void updateShooting(){
		if (Mouse.getButton() == 1 && fireRate <= 0) {
			//get angle
			double dx = Mouse.getX() - Game.getWindowWidth()  /2;
			double dy = Mouse.getY() - Game.getWindowHeight() /2;
			double dir = Math.atan2(dy, dx);
			
			shoot(x, y, dir);
			
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}
	
	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) { 
			sprite = Sprite.player_forward;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_forward_1;
				}
				else
				{
					sprite = Sprite.player_forward_2;
				}
			}
		}
		if (dir == 1) { 
			sprite = Sprite.player_side ;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				}
				else
				{
					sprite = Sprite.player_side_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_back;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_back_1;
				}
				else
				{
					sprite = Sprite.player_back_2;
				}
			}
		}
		if (dir == 3) {
			flip = 1;
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				}
				else
				{
					sprite = Sprite.player_side_2;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
	
}
