package scenes;

import static helpz.Constants.Towers.ARCHER;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.Game;
import managers.EnemyManager;
import managers.ProjectileManager;
import managers.TowerManager;
import maplayers.MapLayer1;
import helpz.Constants;
import helpz.LevelBuilder;

public class Playing extends GameScene implements SceneMethods {

	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private EnemyManager enemyManager;
	private LevelBuilder levelBuilder;
	private TowerManager towerManager;
	private ProjectileManager projManager;
	
	public Playing(Game game) {
		super(game);
		importImg();
		loadSprites();
		
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
		
		levelBuilder.DrawMap(g, sprites, Constants.xMatrix, Constants.yMatrix, Constants.DimSprite);
		towerManager.draw(g);
		enemyManager.draw(g);
		projManager.draw(g);
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
public void mouseClicked(int x, int y) {
	// doet nog niks
	
	towerManager.changeTower(x,y);
			
}
	

public void mouseMoved(int x, int y) {
	// doet nog niks
	}



}
