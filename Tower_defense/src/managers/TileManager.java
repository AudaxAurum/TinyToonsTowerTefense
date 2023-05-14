package managers;

import static helpz.Constants.Tiles.BUILDABLE;

import java.util.ArrayList;

import helpz.Constants;
import objects.Tile;

public class TileManager {
	
	private int[][] map;
	
	public ArrayList<Tile> towerPlace = new ArrayList<>();
	
	public TileManager(int[][] map) {
		this.map = map;
		
		initTiles();
	}
	
	private void initTiles() {
		for(int y = 0; y < Constants.yMatrix; y++) {
			for(int x = 0; x < Constants.xMatrix; x++) {
				int i = map[y][x];
				if (i==4) {
					towerPlace.add(new Tile(x*Constants.DimSprite, y*Constants.DimSprite, BUILDABLE));
				}
				
			}
		}
	}
}
