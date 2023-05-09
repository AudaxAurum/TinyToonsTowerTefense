package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemy.Enemy;
import helpz.Constants;
import helpz.LoadSave;
import maplayers.MapLayer1;
import scenes.Playing;

public class EnemyManager {
	
	private Playing playing;
	private BufferedImage[] enemyImgs;
	
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Integer> deadEnemies = new ArrayList<>();

	 
	public EnemyManager(Playing playing) {
		this.playing = playing;
		enemyImgs = new BufferedImage[4];
		addEnemy();
		loadEnemyImgs();
	}
	
	public Playing getPlaying() {
		return playing;
	}

	public void setPlaying(Playing playing) {
		this.playing = playing;
	}

	public BufferedImage[] getEnemyImgs() {
		return enemyImgs;
	}

	public void setEnemyImgs(BufferedImage[] enemyImgs) {
		this.enemyImgs = enemyImgs;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<Integer> getDeadEnemies() {
		return deadEnemies;
	}

	public void setDeadEnemies(ArrayList<Integer> deadEnemies) {
		this.deadEnemies = deadEnemies;
	}

	private void loadEnemyImgs() {
		BufferedImage atlas  =  LoadSave.getSpriteAtlas();
		for (Enemy e: enemies) {
			enemyImgs[0] = atlas.getSubimage(e.getSpriteX()*Constants.DimSprite, e.getSpriteY()*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
			enemyImgs[1] = atlas.getSubimage((e.getSpriteX()+1)*Constants.DimSprite, e.getSpriteY()*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
			enemyImgs[2] = atlas.getSubimage((e.getSpriteX()+2)* Constants.DimSprite, e.getSpriteY()*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		}
		//enemyImgs[3] = atlas.getSubimage(3* Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		// coordinaten van afbeeldingen invullen
	}

	public void update() {
				
		for (Enemy e : enemies) {
			if (e.getAlive()) {
				e.movement(MapLayer1.Level1);
			}
			
			//else {
			//	deadEnemies.add(enemies.indexOf(e));
			//	for (int i : deadEnemies) {
			//		enemies.remove(i);
			//	}
			//}
			//enemies.removeIf(n -> (n.getHealth() <= 0));
			//enemies.removeIf(n -> (n.getAlive() == false));
				
			//System.out.println("enemy dood");
			//System.out.println(enemies);

		}
		
		
		
	}
	public void addEnemy() {
		enemies.add (new Enemy(0, 0, 0, 3));
		enemies.size();
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
