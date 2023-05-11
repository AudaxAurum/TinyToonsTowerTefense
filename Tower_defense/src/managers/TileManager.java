package managers;

import static helpz.Constants.Tiles.BUILDABLE;
import static helpz.Constants.Tiles.UNBUILDABLE;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.Constants;
import maplayers.MapLayer1;
import objects.Tile;
import scenes.Playing;
import tower.Tower;

public class TileManager {
	
	private Playing playing;
	private Tile tile;
	
	public ArrayList<Tile> towerPlace = new ArrayList<>();
	
	public TileManager(Playing  playing) {
		this.playing = playing;
		
		initTiles();
	}
	
	private void initTiles() {
		for(int y = 0; y < Constants.yMatrix; y++) {
			for(int x = 0; x < Constants.xMatrix; x++) {
				int i = MapLayer1.Level1[y][x];
				if (i==4) {
					towerPlace.add(new Tile(x*Constants.DimSprite, y*Constants.DimSprite, BUILDABLE));
				}
				
			}
		}
	}
}