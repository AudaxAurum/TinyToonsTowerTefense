package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Enemy;
import helpz.Constants;
import helpz.LoadSave;
import maplayers.MapLayer1;
import objects.Tower;
import scenes.Playing;

public class TowerManager {
	
	private Playing playing;
	private BufferedImage[] towerImgs;
	private Tower tower;
	private ArrayList<Tower> towers = new ArrayList<>();
	private int towerLevel;
	
	public TowerManager(Playing  playing) {
		this.playing = playing;
		
		loadTowerImgs();
		initTowers();
	}

	private void initTowers() {
		for(int y = 0; y < Constants.yMatrix; y++) {
			for(int x = 0; x < Constants.xMatrix; x++) {
				int i = MapLayer1.Level1[y][x];
				if (i==4) {
					towers.add(tower = new Tower(x*Constants.DimSprite, y*Constants.DimSprite, 0, 0, towerLevel));
				}
			}
		}
		//tower = new Tower(3*64, 6*64, 0, 0);// geef de benodigdheden voor de toren in
		
	}
	
	private void loadTowerImgs() {
		BufferedImage atlas = LoadSave.getSpriteAtlas();
		towerImgs = new BufferedImage[3];
		for (int i = 0; i<2 ; i++) 
			towerImgs[i] = atlas.getSubimage(i*Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite); //voer plaats van tower img in
	}
	public void update() {
		
	}
	public void draw(Graphics g) {
		
		g.drawImage(towerImgs[0], tower.getX(), tower.getY(), null);
	}

}
