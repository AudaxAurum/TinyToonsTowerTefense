	package managers;

import static helpz.Constants.Towers.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.Constants;
import helpz.LoadSave;
import maplayers.MapLayer1;
import objects.Tower;
import scenes.Playing;

public class TowerManager {
	
	private Playing playing;
	private BufferedImage[] towerImgs;
	private Tower tower;
	public  ArrayList<Tower> towers = new ArrayList<>();
	
	public TowerManager(Playing  playing) {
		this.playing = playing;
		
		loadTowerImgs();
		initTowers();

}

	
	public void changeTower(int i) {
		
		towers.get(i).setTowerType(ARCHER);
	
	}


	private void initTowers() {
		for(int y = 0; y < Constants.yMatrix; y++) {
			for(int x = 0; x < Constants.xMatrix; x++) {
				int i = MapLayer1.Level1[y][x];
				if (i==4) {
					towers.add(tower = new Tower(x*Constants.DimSprite, y*Constants.DimSprite, 0, UNBUILD, 0));
				}
			}
		}
		
		
		//tower = new Tower(3*64, 6*64, 0, 0, 0);// geef de benodigdheden voor de toren in
		
	}
	
	private void loadTowerImgs() {
		BufferedImage atlas = LoadSave.getSpriteAtlas();
		towerImgs = new BufferedImage[6];
		for (int i = 0; i<6 ; i++) 
			towerImgs[i] = atlas.getSubimage(i*Constants.DimSprite, 1*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite); //voer plaats van tower img in
	}
	public void update() {
		
	}
	public void draw(Graphics g) {
		for (int i = 0; i < towers.size(); i++) {
			if (towers.get(i).getTowerType() != UNBUILD) {g.drawImage(towerImgs[2], towers.get(i).getX(), towers.get(i).getY(), null);}
		}
	}

}
