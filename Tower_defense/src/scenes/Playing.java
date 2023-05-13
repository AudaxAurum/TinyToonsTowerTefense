package scenes;

import static helpz.Constants.Towers.*;
import static main.GameStates.PLAYING;
import static main.GameStates.SetGameState;
import static helpz.Constants.Tiles.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import enemy.Enemy;
import main.Game;
import managers.EnemyManager;
import managers.ProjectileManager;
import managers.TileManager;
import managers.TowerManager;
import managers.WaveManager;
import maplayers.MapLayer1;
import objects.Tile;
import ui.MyButton;
import ui.UpgradeBar;
import helpz.Constants;
import helpz.LevelBuilder;
import tower.Tower;
import ui.UpgradeBar;

public class Playing extends GameScene implements SceneMethods {

	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private EnemyManager enemyManager;
	private LevelBuilder levelBuilder;
	private TowerManager towerManager;
	private ProjectileManager projManager;
	private TileManager tileManager;
	private MyButton bUpgraden;
	private WaveManager waveManager;
	private int[][] map;
	private UpgradeBar upgradeBar;
	
	private int gold, castle_health, waves, currentwave;
	
	public Playing(Game game, int level) {
		super(game);
		this.map = helpz.Constants.levels.GetMap(level);
		this.gold = helpz.Constants.levels.GetStartGold(level);
		this.castle_health = helpz.Constants.levels.GetCastleHealth(level);
		this.waves = helpz.Constants.levels.GetAmoundOfWaves(level);
		this.currentwave = 0;
		importImg();
		loadSprites();
		
		//upgradeBar = new UpgradeBar(0,Constants.yMatrix*Constants.DimSprite,Constants.xMatrix*Constants.DimSprite,100);
		enemyManager = new EnemyManager(this, level);
		levelBuilder = new LevelBuilder();
		towerManager = new TowerManager(this);
		projManager = new ProjectileManager(this);
		tileManager = new TileManager(this, map);
		upgradeBar = new UpgradeBar(0, 576, 1024, 100, this);
		waveManager = new WaveManager(this);
		
		
	}
	public void update() {
		enemyManager.update();
		towerManager.update();
		projManager.update();
		waveManager.update();
		
		if (isThereMoreWaves()) {
			waveManager.startWaveTimer();
			if (isWaveTimerOver()) {
				waveManager.increaseWaveIndex();

			}
		}
	}
	private boolean isWaveTimerOver() {

		return waveManager.isWaveTimerOver();
	}
	private boolean isThereMoreWaves() {
		return waveManager.isThereMoreWaves();
	}

	@Override
	public void render(Graphics g) {
		
		//upgradeBar.draw(g);
		levelBuilder.DrawMap(g, sprites, Constants.xMatrix, Constants.yMatrix, Constants.DimSprite, map);
		towerManager.draw(g);
		enemyManager.draw(g);
		projManager.draw(g);

		upgradeBar.drawbar(g);
		upgradeBar.drawvalues(g);
		towerManager.drawSelectedTower(g);

	}
	
private void importImg() {
	
	InputStream is = getClass().getResourceAsStream("/Atlas_4T_64.png");
	
	try {
		img = ImageIO.read(is);
	} catch (IOException e) {
		e.printStackTrace();
	}
}


private void loadSprites() {
	
	for (int y = 0; y < 4; y++) {
		for (int x = 0; x < 6; x++) {
			sprites.add(img.getSubimage(x*Constants.DimSprite, y*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite));
		}
	}
}

@Override
public void mouseLeftClicked(int x, int y) {
	// doet nog niks
	//int i = 0;
	for (Tile t : tileManager.towerPlace) {
		if (t.getX() <= x && x <= (t.getX() + Constants.DimSprite) && 
			t.getY() <= y && y <= (t.getY() + Constants.DimSprite)) { //de gold check is effe voorlopig omdat ik nog niet exact weet hoe we dat het beste aanpakken bij verschillende torens.
			
			if (gold >= helpz.Constants.Towers.Getprice(ARCHER0) && t.getTileType() == BUILDABLE) {
				towerManager.changeTower(t);
				gold -= towerManager.towers.get(towerManager.towers.size()-1).getPrice();
			}

			for (Tower i: towerManager.towers) {
					if (t.getX() == i.getX() & t.getY() == i.getY()) {
						towerManager.selectedTower = i;
					}
				}
			}
		}
	if (x<Constants.DimSprite & y<Constants.DimSprite){
		waveManager.createNormalWave();
	}
		//i++;
		//effe voorlopig
	// code werkt nog niet public void shootEnemy (Tower tower, Enemy e) {
	//	projManager.newProjectile(tower, e);
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
			
public BufferedImage getImg() {
	return img;
}
public void setImg(BufferedImage img) {
	this.img = img;
}
public ArrayList<BufferedImage> getSprites() {
	return sprites;
}
public void setSprites(ArrayList<BufferedImage> sprites) {
	this.sprites = sprites;
}
public EnemyManager getEnemyManager() {
	return enemyManager;
}
public void setEnemyManager(EnemyManager enemyManager) {
	this.enemyManager = enemyManager;
}
public LevelBuilder getLevelBuilder() {
	return levelBuilder;
}
public void setLevelBuilder(LevelBuilder levelBuilder) {
	this.levelBuilder = levelBuilder;
}
public TowerManager getTowerManager() {
	return towerManager;
}
public void setTowerManager(TowerManager towerManager) {
	this.towerManager = towerManager;
}
public ProjectileManager getProjManager() {
	return projManager;
}
public WaveManager getWaveManager() {
		return waveManager;
}
public void setProjManager(ProjectileManager projManager) {
	this.projManager = projManager;
}
public MyButton getbUpgraden() {
	return bUpgraden;
}
public void setbUpgraden(MyButton bUpgraden) {
	this.bUpgraden = bUpgraden;
}
public void mouseRightClicked(int x, int y) {
	towerManager.selectedTower = null;
}

public void mouseMoved(int x, int y) {
	// doet nog niks
	}
public void shoot(Tower t,int type, Enemy e) {
	projManager.newProjectile(t, type, e);
	
}

public void GoldReward(int reward) {
	gold += reward;
}
public void Castledmg(int dmg) {
	castle_health -= dmg;
}
public int getGold() {
	return gold;
}
public int getCastle_health() {
	return castle_health;
}
public int getWaves() {
	return waves;
}
public int getCurrentWave() {
	return currentwave;
}


}
