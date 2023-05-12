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
	public  ArrayList<Tower> towers = new ArrayList<>();
	public Tower selectedTower;
	
	public TowerManager(Playing  playing) {
		this.playing = playing;
		
		loadTowerImgs();

	}

	
	public void changeTower(Tile tile) {
		if (tile.getTileType() == BUILDABLE) {
			tile.setTileType(UNBUILDABLE);
			towers.add(new Archer(tile.getX(), tile.getY(), 0, ARCHER0, 0));
			System.out.println(towers.get(0).getCurrentDmg());
			System.out.println(towers.get(0).getTowerType());
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
		return distancetoenemy <=  (tower.getCurrentRange()/2);
		}
	
	public void drawSelectedTower(Graphics g) {
		if (selectedTower != null) {
			drawRange(g, selectedTower);
			drawUpgradeButton(g);
		}
	}


	private void drawUpgradeButton(Graphics g) {
		if (selectedTower != null) {
			g.setColor(Color.GREEN);
			g.fillRect(Constants.DimSprite*Constants.xMatrix - 150, Constants.DimSprite*Constants.yMatrix + 30, 80, 40);
			g.setColor(Color.BLACK);
			g.drawString("Upgrade", Constants.DimSprite*Constants.xMatrix - 140, Constants.DimSprite*Constants.yMatrix + 55);
		}
	}
	
	public void upgradeTower() {
		if (selectedTower != null) {
			selectedTower.setTowerLevel(selectedTower.getTowerLevel()+1);			
		}
	}


	private void drawRange(Graphics g, Tower tower) {
		g.setColor(Color.WHITE);
		g.drawOval( tower.getX() - (int) tower.getCurrentRange()/2 + helpz.Constants.DimSprite/2,
					tower.getY() - (int) tower.getCurrentRange()/2 + helpz.Constants.DimSprite/2,
					(int) tower.getCurrentRange(), (int) tower.getCurrentRange());
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
