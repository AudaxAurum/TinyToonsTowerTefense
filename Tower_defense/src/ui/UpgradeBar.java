package ui;

import static helpz.Constants.Towers.*;
import static main.GameStates.PLAYING;
import static main.GameStates.SetGameState;
import managers.TowerManager;
import objects.Tile;

import java.awt.Color;
import java.awt.Graphics;

import helpz.Constants;
import scenes.Playing;

public class UpgradeBar {
	
	private int x, y, width, height;
	private Playing playing;
	private MyButton bCrusher,bArcher;
	public static int Towerselector;
	private TowerManager towerManager;
	private boolean selectingTower = false, SpecializationTime = false;
	private Tile tile;

	public UpgradeBar(int x, int y, int width, int height, Playing playing,TowerManager towerManager ) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.playing = playing;
		this.towerManager = towerManager;
		initButtons() ;
		
	}
public void initButtons() {
		
		int w = 80;
		int h= 40;
		int x = 100;
		int y = 600;

		 bCrusher = new MyButton(x+100, y, w, h ,"Crusher");
		 bArcher = new MyButton(x, y, w, h ,"Archer");
		
	}
	
	public void drawbar(Graphics g) {
		g.setColor(new Color(46,25,13));
		g.fillRect(x, y, width, height);
	}
	public void drawvalues(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.drawString("Health = " + playing.getCastle_health(), x, y + 15);
		g.drawString("Gold = " + playing.getGold(), x, y + 30 );
		g.drawString("Wave" + playing.getCurrentWave() + "/" + playing.getWaves(), x, y + 45 );
	}



	public void drawBuildButtons(Graphics g) {
		bCrusher.draw(g);
		bArcher.draw(g);

		
	}
private void drawSpecialisationButton(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillRect(Constants.DimSprite*Constants.xMatrix - 250, Constants.DimSprite*Constants.yMatrix + 30, 80, 40);
		g.fillRect(Constants.DimSprite*Constants.xMatrix - 150, Constants.DimSprite*Constants.yMatrix + 30, 80, 40);
		g.setColor(Color.BLACK);
		g.drawString("Longbow", Constants.DimSprite*Constants.xMatrix - 235, Constants.DimSprite*Constants.yMatrix + 55);
		g.drawString("Swiftbow", Constants.DimSprite*Constants.xMatrix - 135, Constants.DimSprite*Constants.yMatrix + 55);

		
	}
	public void draw(Graphics g) {
		drawbar(g);
		drawvalues(g);
		
		if (selectingTower && (towerManager.selectedTower == null)) {
			drawBuildButtons(g);
		}
		
		if (SpecializationTime) {
			drawSpecialisationButton(g);
		}
	}

	public static int getTowerselector() {
		return Towerselector;
	}
	public void setTowerselector(int towerselector) {
		Towerselector = towerselector;
	}
	public void Clicked(int x, int y) {
		
		if (selectingTower) {
			if (bCrusher.getBounds().contains(x, y)) {
				if (playing.getGold() >= helpz.Constants.Towers.Getprice(CRUSHER0)) {
					
					playing.changeTower(tile, CRUSHER0);
					playing.GoldCost(helpz.Constants.Towers.Getprice(CRUSHER0));
					selectingTower = false;
				}
			}
			if (bArcher.getBounds().contains(x, y)) {
				if (playing.getGold() >= helpz.Constants.Towers.Getprice(ARCHER0)) {
					
					playing.changeTower(tile, ARCHER0);
					playing.GoldCost(helpz.Constants.Towers.Getprice(ARCHER0));
					selectingTower = false;
				}
			}
		}
		if (towerManager.selectedTower != null) {
			if ((Constants.DimSprite*Constants.xMatrix - 350) <= x && x <= (Constants.DimSprite*Constants.xMatrix - 270) &&
				(Constants.DimSprite*Constants.yMatrix + 30) <= y && y <= (Constants.DimSprite*Constants.yMatrix + 70)) {
				
				if (playing.getGold() >= helpz.Constants.Towers.GetUpgradePriceFactor(towerManager.selectedTower.getTowerType()) * helpz.Constants.Towers.Getprice(towerManager.selectedTower.getTowerType()) * towerManager.selectedTower.getTowerLevel()) {
					
					towerManager.upgradeTower();
					playing.GoldCost((int) helpz.Constants.Towers.GetUpgradePriceFactor(towerManager.selectedTower.getTowerType()) * helpz.Constants.Towers.Getprice(towerManager.selectedTower.getTowerType()) * towerManager.selectedTower.getTowerLevel());
					
					if (towerManager.selectedTower.getTowerLevel() == 4) {
						SpecializationTime = true;
					}
					
					else {
						SpecializationTime = false;
					}
				}
			}
			
			if (towerManager.selectedTower.getTowerType() == ARCHER0) {
				if ((Constants.DimSprite*Constants.xMatrix - 250) <= x && x <= (Constants.DimSprite*Constants.xMatrix - 170) &&
					(Constants.DimSprite*Constants.yMatrix + 30) <= y && y <= (Constants.DimSprite*Constants.yMatrix + 70)) {
					
					if (playing.getGold() >= helpz.Constants.Towers.GetUpgradePriceFactor(ARCHER1)* helpz.Constants.Towers.Getprice(towerManager.selectedTower.getTowerType()/4 * towerManager.selectedTower.getTowerLevel())) {
						
						towerManager.selectedTower.setTowerType(ARCHER1);
						towerManager.upgradeTower();
						SpecializationTime = false;
					}
				}
		
				if ((Constants.DimSprite*Constants.xMatrix - 150) <= x && x <= (Constants.DimSprite*Constants.xMatrix - 70) &&
					(Constants.DimSprite*Constants.yMatrix + 30) <= y && y <= (Constants.DimSprite*Constants.yMatrix + 70)) {
					
					if (playing.getGold() >= helpz.Constants.Towers.GetUpgradePriceFactor(ARCHER2)* helpz.Constants.Towers.Getprice(towerManager.selectedTower.getTowerType()/4 * towerManager.selectedTower.getTowerLevel())) {
						
						towerManager.selectedTower.setTowerType(ARCHER2);
						towerManager.upgradeTower();
						SpecializationTime = false;
					}
				}
			}
		}
	}
	public void selectingTower() {
		selectingTower = true;
	}
	public void notselectingTower() {
		selectingTower = false;
	}
	public void setTile(Tile t) {
		this.tile = t;
	}
}
