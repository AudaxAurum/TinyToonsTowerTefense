package scenes;

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
import managers.TowerManager;
import maplayers.MapLayer1;
import helpz.LevelBuilder;

public class Playing extends GameScene implements SceneMethods {

	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private EnemyManager enemyManager;
	private LevelBuilder levelBuilder;
	private TowerManager towerManager;
	
	private int xMatrix = 16;
	private int yMatrix = 9;
	
	private int DimSprite = 64;

	
	
	public Playing(Game game) {
		super(game);
		importImg();
		loadSprites();
		
		enemyManager = new EnemyManager(this);
		levelBuilder = new LevelBuilder();
		towerManager = new TowerManager(this);
	}
	public void update() {
		enemyManager.update(); //no idea why dees een fout geeft 
		towerManager.update();
	}

	@Override
	public void render(Graphics g) {
		
		levelBuilder.DrawMap(g, sprites, xMatrix, yMatrix, DimSprite);
		enemyManager.draw(g);
		towerManager.draw(g);
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
	
	for (int y = 0; y < 1; y++) {
		for (int x = 0; x < 5; x++) {
			sprites.add(img.getSubimage(x*DimSprite, y*DimSprite, DimSprite, DimSprite));
		}
	}
}

@Override
public void mouseClicked(int x, int y) {
	// TODO Auto-generated method stub
	
}


}

