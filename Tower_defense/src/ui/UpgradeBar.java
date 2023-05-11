package ui;

import java.awt.Color;
import java.awt.Graphics;

import scenes.Playing;

public class UpgradeBar {
	
	private int x, y, width, height;
	
	public UpgradeBar(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(46,25,13));
		g.fillRect(x, y, width, height);
	}
}
