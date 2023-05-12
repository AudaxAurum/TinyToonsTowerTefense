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
	private int[][] map;
	
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Integer> deadEnemies = new ArrayList<>();
	
	
	 
	public EnemyManager(Playing playing, int level) {
		this.playing = playing;
		this.map = helpz.Constants.levels.GetMap(level);
		enemyImgs = new BufferedImage[9];
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
		enemyImgs[0] = atlas.getSubimage(0*Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[1] = atlas.getSubimage(1*Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[2] = atlas.getSubimage(2*Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[3] = atlas.getSubimage(3*Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[4] = atlas.getSubimage(4*Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[5] = atlas.getSubimage(5* Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[6] = atlas.getSubimage(0*Constants.DimSprite, 3*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[7] = atlas.getSubimage(1*Constants.DimSprite, 3*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		enemyImgs[8] = atlas.getSubimage(2* Constants.DimSprite, 3*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		//enemyImgs[3] = atlas.getSubimage(3* Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		// coordinaten van afbeeldingen invullen
	}

	public void update() {
		if(isTimeForNewEnemy()) {
			spawnEnemy();
		}
		for (Enemy e : enemies) {
			if (e.getAlive()) {
				e.movement(map);
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
	private boolean isTimeForNewEnemy() {
		if (playing.getWaveManager().isTimeForNewEnemy()){
			
		}
		return false;
	}

	private void spawnEnemy() {
		// TODO Auto-generated method stub
		
	}

	public void addEnemy(int enemytype) {
		enemies.add (new Enemy(enemytype, this));
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
		g.drawImage(enemyImgs[e.getSprite()], (int) e.getX(), (int) e.getY(), null);
		}
		else if (e.timerhelp == 1 || e.timerhelp == 3) {
		g.drawImage(enemyImgs[e.getSprite() + 1], (int) e.getX(), (int) e.getY(), null);
		}
		else if (e.timerhelp == 2) {
		g.drawImage(enemyImgs[e.getSprite() + 2], (int) e.getX(), (int) e.getY(), null);
		}
	}

	public void RewardGold(int reward) {
		playing.GoldReward(reward);
	}
	
	public void castledmg(int dmg) {
		playing.Castledmg(dmg);
	}

}
