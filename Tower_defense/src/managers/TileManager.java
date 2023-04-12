package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.LoadSave;
import objects.Tile;

public class TileManager {
	
	public Tile Grass, Road, Bend, Cross, Build;
	
	public BufferedImage Atlas_4T;
	
	public ArrayList<Tile> tiles = new ArrayList<>();
	
	public TileManager() {
		
		loadAtlas();
		createTiles();
		
	}

	private void createTiles() {
		// TODO Auto-generated method stub
		tiles.add(Grass = new Tile(getSprite(3,1)));
		tiles.add(Road = new Tile(getSprite(1,1)));
		tiles.add(Bend = new Tile(getSprite(2,1)));
		tiles.add(Cross = new Tile(getSprite(4,1)));
		tiles.add(Build = new Tile(getSprite(5,1)));
		
	}

	private void loadAtlas() {
		// TODO Auto-generated method stub
		
		Atlas_4T = LoadSave.getSpriteAtlas();
		
	}
	
	public BufferedImage getSprite(int id) {
		
		return tiles.get(id).GetSprite();
		
	}
	
	private BufferedImage getSprite(int xCord, int yCord) {
		
		return Atlas_4T.getSubimage(32*xCord,32*yCord,32,32);
	}
	
}
