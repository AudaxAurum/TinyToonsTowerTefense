package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.Constants;
import helpz.LoadSave;
import maplayers.MapLayer1;
import objects.Enemy;
import scenes.Playing;

public class EnemyManager {
	
	private Playing playing;
	private BufferedImage[] enemyImgs;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	 
	public EnemyManager(Playing playing) {
		this.playing = playing;
		enemyImgs = new BufferedImage[4];
		addEnemy();
		loadEnemyImgs();
	}
	
	private void loadEnemyImgs() {
		BufferedImage atlas  =  LoadSave.getSpriteAtlas();
		enemyImgs[0] = atlas.getSubimage(0*Constants.DimSprite, 3*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[1] = atlas.getSubimage(1*Constants.DimSprite, 3*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[2] = atlas.getSubimage(2* Constants.DimSprite, 3*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		//enemyImgs[3] = atlas.getSubimage(3* Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		// coordinaten van afbeeldingen invullen
	}

	public void update() {
		
		for (Enemy e : enemies)
			if (e.getAlive()) {
				e.movement(0.7, MapLayer1.Level1);
			}
		
	}
	public void addEnemy() {
		enemies.add (new Enemy(0, 0, 0, //EnemyManager?));
	}
	
	public void draw(Graphics g) {
		for (Enemy e : enemies)
			if (e.getAlive()) {
				drawEnemy(e,g);
			}
	}

	private void drawEnemy(Enemy e, Graphics g) {
		if (e.timerhelp == 0) {
		g.drawImage(enemyImgs[0], (int) e.getX(), (int) e.getY(), null);
		}
		if (e.timerhelp == 1 || e.timerhelp == 3) {
		g.drawImage(enemyImgs[0 + 1], (int) e.getX(), (int) e.getY(), null);
		}
		if (e.timerhelp == 2) {
		g.drawImage(enemyImgs[0 + 2], (int) e.getX(), (int) e.getY(), null);
		}
	}
	


}
