	package managers;

import static helpz.Constants.Towers.*;
import static helpz.Constants.Tiles.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemy.Enemy;
import helpz.Constants;
import helpz.LoadSave;
import maplayers.MapLayer1;
import objects.Tile;
import scenes.Playing;
import tower.Archer;
import tower.Tower;

public class TowerManager {
	
	private Playing playing;
	private BufferedImage[] towerImgs;
	private Tower tower;
	public  ArrayList<Tower> towers = new ArrayList<>();
	public Tower selectedTower;
	
	public TowerManager(Playing  playing) {
		this.playing = playing;
		
		loadTowerImgs();

}

	
	public void changeTower(Tile tile) {
		if (tile.getTileType() == BUILDABLE) {
			tile.setTileType(UNBUILDABLE);
			towers.add(new Archer(tile.getX(), tile.getY(), 0, ARCHER, 0));
		}
	
	}
	
	private void attackEnemy() {
		for (Tower t: towers) {
			for (Enemy e : playing.getEnemyManager().getEnemies()) {
				if(e.getAlive()) {
					if (isEnemyInRange(t, e)) {
						if(t.cooldowncheck()) {
							playing.shoot(t,e);
						}
					}
				}
			}
		}
	}
	private boolean isEnemyInRange(Tower tower, Enemy e) {
		int distancetoenemy = helpz.Constants.GetRange(tower.getX(), tower.getY(), e.getX(), e.getY());
		return distancetoenemy <=  (tower.getDefaultRange()/2);
		}
	
	public void drawSelectedTower(Graphics g, Tower tower) {
		if (selectedTower != null) {
			drawRange(g, selectedTower);
			drawUpgradeButton();
		}
	}


	private void drawUpgradeButton() {
		
	}


	private void drawRange(Graphics g, Tower tower) {
		g.setColor(Color.WHITE);
		g.drawOval( tower.getX() - (int) helpz.Constants.Towers.GetDefaultRange(tower.getTowerType())/2 + helpz.Constants.DimSprite/2,
					tower.getY() - (int) helpz.Constants.Towers.GetDefaultRange(tower.getTowerType())/2 + helpz.Constants.DimSprite/2,
					(int) helpz.Constants.Towers.GetDefaultRange(tower.getTowerType()), (int) helpz.Constants.Towers.GetDefaultRange(tower.getTowerType()));		
	}
	
	private void loadTowerImgs() {
		BufferedImage atlas = LoadSave.getSpriteAtlas();
		towerImgs = new BufferedImage[6];
		for (int i = 0; i<6 ; i++) 
			towerImgs[i] = atlas.getSubimage(i*Constants.DimSprite, 1*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite); //voer plaats van tower img in
	}
	
	public void update() {
		attackEnemy();
		for (Tower t: towers) {
			t.update();
		}
	}
	
	public void draw(Graphics g) {
		for (Tower t : towers) {
			if (t.getTowerType() != UNBUILD) {
				g.drawImage(towerImgs[2], t.getX(), t.getY(), null);
			}
		}
	}

}
