package objects;

import java.awt.image.BufferedImage;

public class Tile {
	
	public Tile(BufferedImage Sprite) {
		
		this.Sprite = Sprite;
		
	}
	
	private BufferedImage Sprite;
	
	public BufferedImage GetSprite() {
		
		return Sprite;
		
	}


}
// wss verwijderen