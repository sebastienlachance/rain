package com.creatiom.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.creatiom.rain.entity.mob.Chaser;
import com.creatiom.rain.entity.mob.Dummy;
import com.creatiom.rain.entity.mob.Star;

public class SpawnLevel extends Level {
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
		} 
		add(new Star(17, 35));
		for (int i = 0; i < 2; i++) {
			add(new Chaser(20, 55));	
			add(new Dummy(20, 55));
		}
	}
	
	// Grass = 0xFF0000
	// Flower = 0xFFFF00
	// Rock = 0x7F7F00
	protected void generateLevel() {
	}
	
}
