package com.creatiom.rain.level.tile;

import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.Sprite;

public class RockTile extends Tile {
	
	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this.sprite);
	}
	
	public boolean solid() {
		return true;
	}
}
