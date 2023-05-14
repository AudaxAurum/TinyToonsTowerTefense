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
	public float upgradePrice;
	
	
	public TowerManager(Playing  playing) {
		this.playing = playing;
		loadTowerImgs();
		

	}

	
	public void changeTower(Tile tile, int towerselector) {
		tile.setTileType(UNBUILDABLE);
		towers.add(new Tower(tile.getX(), tile.getY(), 0, towerselector, 0));
		selectedTower = towers.get(towers.size()-1);
		upgradeTower();
	
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
			g.setColor(Color.WHITE);

		}
	}


	private void drawUpgradeButton(Graphics g) {
		upgradePrice = helpz.Constants.Towers.GetUpgradePriceFactor(selectedTower.getTowerType()) * helpz.Constants.Towers.Getprice(selectedTower.getTowerType()) /4* selectedTower.getTowerLevel();

			g.setColor(Color.GREEN);
			g.fillRect(Constants.DimSprite*Constants.xMatrix - 350, Constants.DimSprite*Constants.yMatrix + 30, 80, 40);
			g.setColor(Color.WHITE);
			g.drawString("lvl = " + selectedTower.getTowerLevel() + " : " + "Upgrade", Constants.DimSprite*Constants.xMatrix - 350, Constants.DimSprite*Constants.yMatrix + 55 - 30);
			g.drawString(Integer.toString((int) upgradePrice)
						, Constants.DimSprite*Constants.xMatrix - 335, Constants.DimSprite*Constants.yMatrix + 55);
			
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
			g.drawImage(towerImgs.get(Constants.Towers.GetSprite(t.getTowerType())), (int) t.getX(), (int) t.getY(), null);//nu wel
		}
	}

}
