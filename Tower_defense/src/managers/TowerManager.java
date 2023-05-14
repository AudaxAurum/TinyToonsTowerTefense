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
import ui.UpgradeBar;

public class TowerManager {
	
	private Playing playing;
	private ArrayList<BufferedImage> towerImgs = new ArrayList<>();
	public  ArrayList<Tower> towers = new ArrayList<>();
	public Tower selectedTower;
	
	
	public TowerManager(Playing  playing) {
		this.playing = playing;
		loadTowerImgs();

	}

	
	public void changeTower(Tile tile, int towerselector) {
		tile.setTileType(UNBUILDABLE);
		towers.add(new Tower(tile.getX(), tile.getY(), 0, towerselector, 0));
	
	}
	
	private void attackEnemy() {
		for (Tower t: towers) {
			for (Enemy e : playing.getEnemyManager().getEnemies()) {
				if(e.getAlive()) {
					if (isEnemyInRange(t, e)) {
						if(t.cooldowncheck(t)) {
							playing.shoot(t,t.GetProjectile(),e);
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

			g.setColor(Color.GREEN);
			g.fillRect(Constants.DimSprite*Constants.xMatrix - 350, Constants.DimSprite*Constants.yMatrix + 30, 80, 40);
			g.setColor(Color.WHITE);
			g.drawString("Upgrade", Constants.DimSprite*Constants.xMatrix - 335, Constants.DimSprite*Constants.yMatrix + 55 - 30);
		
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
		for (int y = 0; y < 2; y++) {
			for (int x = 0; x < 6; x++) {
				towerImgs.add(atlas.getSubimage(x*Constants.DimSprite, (1 + y)*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite));
			}
		}
	}
	
	public void update() {
		attackEnemy();
		for (Tower t: towers) {
			t.update();
			
		}
	}
	
	public void draw(Graphics g) {
		for (Tower t : towers) {
			if (t.getTowerType() == ARCHER0) {
				g.drawImage(towerImgs.get(0), t.getX(), t.getY(), null);
			}
			else if (t.getTowerType() == ARCHER1) {
				g.drawImage(towerImgs.get(2), t.getX(), t.getY(), null);
			}
			else if (t.getTowerType() == ARCHER2) {
				g.drawImage(towerImgs.get(4), t.getX(), t.getY(), null);
			}
			else if (t.getTowerType() == CRUSHER0) {
				g.drawImage(towerImgs.get(6), t.getX(), t.getY(), null);
			}
		}
	}

}
