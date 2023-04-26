package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Enemy;
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
		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 16; x++) {
				int i = MapLayer1.Level1[y][x];
				if (i==4) {
					towers.add(tower = new Tower(x*64, y*64, 0, 0, towerLevel));
				}
			}
		}
		//tower = new Tower(3*64, 6*64, 0, 0);// geef de benodigdheden voor de toren in
		
	}
	
	private void loadTowerImgs() {
		BufferedImage atlas = LoadSave.getSpriteAtlas();
		towerImgs = new BufferedImage[3];
		for (int i = 0; i<2 ; i++) 
			towerImgs[i] = atlas.getSubimage(i*64, 2*64, 64, 64); //voer plaats van tower img in
	}
	public void update() {
		
	}
	public void draw(Graphics g) {
		
		g.drawImage(towerImgs[0], tower.getX(), tower.getY(), null);
	}

}
