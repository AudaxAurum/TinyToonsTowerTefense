package scenes;

import static helpz.Constants.Towers.ARCHER;
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

import main.Game;
import managers.EnemyManager;
import managers.ProjectileManager;
import managers.TowerManager;
import maplayers.MapLayer1;
import objects.Tower;
import ui.MyButton;
import ui.UpgradeBar;
import helpz.Constants;
import helpz.LevelBuilder;

public class Playing extends GameScene implements SceneMethods {

	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private EnemyManager enemyManager;
	private LevelBuilder levelBuilder;
	private TowerManager towerManager;
	private ProjectileManager projManager;
	private MyButton bUpgraden;
	//private UpgradeBar upgradeBar;
	
	public Playing(Game game) {
		super(game);
		importImg();
		loadSprites();
		
		//upgradeBar = new UpgradeBar(0,Constants.yMatrix*Constants.DimSprite,Constants.xMatrix*Constants.DimSprite,100);
		enemyManager = new EnemyManager(this);
		levelBuilder = new LevelBuilder();
		towerManager = new TowerManager(this);
		projManager = new ProjectileManager(this);
	}
	public void update() {
		enemyManager.update();
		towerManager.update();
		projManager.update();
	}

	@Override
	public void render(Graphics g) {
		
		//upgradeBar.draw(g);
		levelBuilder.DrawMap(g, sprites, Constants.xMatrix, Constants.yMatrix, Constants.DimSprite);
		towerManager.draw(g);
		enemyManager.draw(g);
		projManager.draw(g);
		towerManager.drawSelectedTower(g, towerManager.selectedTower);

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
	
	for (Tower t : towerManager.towers) {
		if (t.getX() <= x && x <= (t.getX() + Constants.DimSprite) && 
			t.getY() <= y && y <= (t.getY() + Constants.DimSprite)) {
			
			towerManager.changeTower(t);
			towerManager.selectedTower = t;
			

		}
		else if (x <= 64 && x >= 0 && y <= 64 && y >= 0) {
			enemyManager.addEnemy();
		}
		
		
		}//effe voorlopig
	
	}
			
public void mouseRightClicked(int x, int y) {
	towerManager.selectedTower = null;
}
	

public void mouseMoved(int x, int y) {
	// doet nog niks
	}



}
