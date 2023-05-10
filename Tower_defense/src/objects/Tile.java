package objects;

import static helpz.Constants.Tiles.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.Constants;
import maplayers.MapLayer1;
import tower.Tower;

public class Tile {
	
	int x, y, TowerType;
	
	public Tile(int x, int y, int TileType) {
		
		this.x = x;
		this.y = y;
		this.TowerType = TowerType;
				
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTileType() {
		return TowerType;
	}

	public void setTileType(int towerType) {
		TowerType = towerType;
	}

}
