package ui;

import static helpz.Constants.Towers.*;
import static main.GameStates.PLAYING;
import static main.GameStates.SetGameState;
import managers.TowerManager;

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



	public void drawButtons(Graphics g) {
		bCrusher.draw(g);
		bArcher.draw(g);

		
	}

	public static int getTowerselector() {
		return Towerselector;
	}
	public void setTowerselector(int towerselector) {
		Towerselector = towerselector;
	}
	public void Clicked(int x, int y) {
		if (bCrusher.getBounds().contains(x, y)) {
			Towerselector =helpz.Constants.Towers.CRUSHER0;
			System.out.print(Towerselector);
		}
		if (bArcher.getBounds().contains(x, y)) {
			Towerselector =helpz.Constants.Towers.ARCHER0;
			System.out.print(Towerselector);
		}
		if (towerManager.selectedTower != null) {
			if ((Constants.DimSprite*Constants.xMatrix - 350) <= x && x <= (Constants.DimSprite*Constants.xMatrix - 270) &&
					(Constants.DimSprite*Constants.yMatrix + 30) <= y && y <= (Constants.DimSprite*Constants.yMatrix + 70)) {
			
					towerManager.upgradeTower();
					System.out.println(towerManager.selectedTower.getTowerLevel());
			}
		
			if ((Constants.DimSprite*Constants.xMatrix - 250) <= x && x <= (Constants.DimSprite*Constants.xMatrix - 170) &&
				(Constants.DimSprite*Constants.yMatrix + 30) <= y && y <= (Constants.DimSprite*Constants.yMatrix + 70)) {
				
					towerManager.selectedTower.setTowerType(ARCHER1);
					towerManager.upgradeTower();

			}
		
			if ((Constants.DimSprite*Constants.xMatrix - 150) <= x && x <= (Constants.DimSprite*Constants.xMatrix - 70) &&
				(Constants.DimSprite*Constants.yMatrix + 30) <= y && y <= (Constants.DimSprite*Constants.yMatrix + 70)) {
				
					towerManager.selectedTower.setTowerType(ARCHER2);
					towerManager.upgradeTower();

			}
		}
	}
	
}
