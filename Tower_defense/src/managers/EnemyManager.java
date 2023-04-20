package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemies.Enemy;
import helpz.LoadSave;
import maplayers.MapLayer1;
import scenes.Playing;

public class EnemyManager {
	
	private Playing playing;
	private BufferedImage[] enemyImgs;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	 
	public EnemyManager(Playing playing) {
		this.playing = playing;
		enemyImgs = new BufferedImage[4];
		addEnemy(3*32,0);
		loadEnemyImgs();
	}
	
	private void loadEnemyImgs() {
		BufferedImage atlas  =  LoadSave.getSpriteAtlas();
		enemyImgs[0] = atlas.getSubimage(0*64, 2*64, 64, 64);
		enemyImgs[1] = atlas.getSubimage(1*64, 2*64, 64, 64);
		enemyImgs[2] = atlas.getSubimage(2* 64, 2*64, 64, 64);
		//enemyImgs[3] = atlas.getSubimage(3* 64, 2*64, 64, 64);
				// coordinaten van afbeeldingen invullen
		//berten moet eerst nog toevoegen
		
	}

	public void update() {
		
		for (Enemy e : enemies)
			e.movement(1, 0, 3, MapLayer1.Level1);
		
	}
	public void addEnemy(int x, int y) {
		enemies.add (new Enemy(x ,y , 0 ,0));
	}
	
	public void draw(Graphics g) {
		for (Enemy e : enemies)
		drawEnemy(e,g);
		
	}

	private void drawEnemy(Enemy e, Graphics g) {
		g.drawImage(enemyImgs[0], (int) e.getX(), (int) e.getY(), null);
	}
	
	


}
