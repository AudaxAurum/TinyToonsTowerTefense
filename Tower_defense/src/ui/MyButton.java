package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class MyButton {
	private int  x, y, width, height;
	private String text;
	
	private Rectangle bounds;

	public MyButton (int x, int y, int width, int height, String text) {
		this.x =  x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		
		initBounds();
	}
	
	private void initBounds() {
		this.bounds = new Rectangle(x, y ,width, height);
	}
	public void draw(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		
		
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		
		drawText(g);
	}
	
	private void drawText(Graphics g) {
		int width = g.getFontMetrics().stringWidth(text);
		int height = g.getFontMetrics().getHeight();
		g.drawString(text, x + width/2 , y + (int) (height*1.5));		
	}

	public Rectangle getBounds() {
		return bounds;
	}


}
	
