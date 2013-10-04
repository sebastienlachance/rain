package com.creatiom.rain.level.tile.spawn_level;

import com.creatiom.rain.graphics.Screen;
import com.creatiom.rain.graphics.Sprite;
import com.creatiom.rain.level.tile.Tile;

public class SpawnWaterTile extends Tile {
	
	public SpawnWaterTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this.sprite);
	} 
}
