package scenes;

import static helpz.Constants.Towers.ARCHER0;
import static main.GameStates.PLAYING;
import static main.GameStates.SetGameState;

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
import maplayers.MapLayer1;
import objects.Tile;
import ui.MyButton;
import ui.UpgradeBar;
import helpz.Constants;
import helpz.LevelBuilder;
import tower.Tower;
import ui.UpgradeBar;
import levels.level1;

public class Playing extends GameScene implements SceneMethods {

	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private EnemyManager enemyManager;
	private LevelBuilder levelBuilder;
	private TowerManager towerManager;
	private ProjectileManager projManager;
	private TileManager tileManager;
	private MyButton bUpgraden;
	private int[][] map;
	private UpgradeBar upgradeBar;
	
	public int gold = 200; //starting value
	public int castle_health = 20;
	
	public Playing(Game game, int level) {
		super(game);
		this.map = helpz.Constants.levels.GetMap(level);
		importImg();
		loadSprites();
		
		//upgradeBar = new UpgradeBar(0,Constants.yMatrix*Constants.DimSprite,Constants.xMatrix*Constants.DimSprite,100);
		enemyManager = new EnemyManager(this, level);
		levelBuilder = new LevelBuilder();
		towerManager = new TowerManager(this);
		projManager = new ProjectileManager(this);
		tileManager = new TileManager(this, map);
		upgradeBar = new UpgradeBar(0, 576, 1024, 100, this);
		
		
	}
	public void update() {
		enemyManager.update();
		towerManager.update();
		projManager.update();
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
			t.getY() <= y && y <= (t.getY() + Constants.DimSprite) && (gold >= helpz.Constants.Towers.Getprice(ARCHER0))) { //de gold check is effe voorlopig omdat ik nog niet exact weet hoe we dat het beste aanpakken bij verschillende torens.
			
			towerManager.changeTower(t);
			
			for (Tower i: towerManager.towers) {
					if (t.getX() == i.getX() & t.getY() == i.getY()) {
						towerManager.selectedTower = i;
						gold -= i.getPrice();
					}
				}
			}
		}
	if (x<Constants.DimSprite & y<Constants.DimSprite){
		enemyManager.addEnemy(helpz.Constants.Enemies.BOMBER);
	}
		//i++;
		//effe voorlopig
	// code werkt nog niet public void shootEnemy (Tower tower, Enemy e) {
	//	projManager.newProjectile(tower, e);
	
	if ((Constants.DimSprite*Constants.xMatrix - 150) <= x && x <= (Constants.DimSprite*Constants.xMatrix - 70) &&
		(Constants.DimSprite*Constants.yMatrix + 30) <= y && y <= (Constants.DimSprite*Constants.yMatrix + 70)) {
		
		towerManager.upgradeTower();
		System.out.println(towerManager.selectedTower.getTowerLevel());
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
public void shoot(Tower t, Enemy e) {
	projManager.newProjectile(t, e);
	
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
public void setGold(int gold) {
	this.gold = gold;
}
public int getCastle_health() {
	return castle_health;
}
public void setCastle_health(int castle_health) {
	this.castle_health = castle_health;
}


}
