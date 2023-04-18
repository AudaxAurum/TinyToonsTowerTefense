package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import enemies.Enemy;
import helpz.LoadSave;
import scenes.Playing;

public class EnemyManager {
	
	private Playing playing;
	private BufferedImage[] enemyImgs;
	private Enemy TestEnemy;
	 
	public EnemyManager(Playing playing) {
		this.playing = playing;
		enemyImgs = new BufferedImage[4];
				//hoeveelheid aan enemies in array invullen
		TestEnemy = new Enemy(64 * 3, 32 * 9, 0, 0);
		loadEnemyImgs();
	}
	
	private void loadEnemyImgs() {
		BufferedImage atlas  =  LoadSave.getSpriteAtlas();
		enemyImgs[0] = atlas.getSubimage(0, 32, 32, 0);
		enemyImgs[1] = atlas.getSubimage(32, 32, 32, 0);
		enemyImgs[2] = atlas.getSubimage(2* 32, 32, 32, 0);
		enemyImgs[3] = atlas.getSubimage(3* 32, 32, 32, 0);
				// coordinaten van afbeeldingen invullen
		
	}

	public void update() {
		
	}
	public void draw(Graphics g) {
		
		drawEnemy(TestEnemy, g);
		
	}
	private void drawEnemy(Enemy e, Graphics g) {
		g.drawImage(enemyImgs[0],(int) e.getX(),(int)  e.getY(), null);
		
	}
}
