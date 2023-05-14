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
	private ArrayList<BufferedImage> enemyImgs = new ArrayList<>();
	private int[][] map;
	
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Integer> deadEnemies = new ArrayList<>();
	
	
	 
	public EnemyManager(Playing playing, int level) {
		this.playing = playing;
		this.map = helpz.Constants.levels.GetMap(level);
		loadEnemyImgs();
	}
	
	public Playing getPlaying() {
		return playing;
	}

	public void setPlaying(Playing playing) {
		this.playing = playing;
	}

	/*public BufferedImage[] getEnemyImgs() {
		return enemyImgs;
	}

	public void setEnemyImgs(BufferedImage[] enemyImgs) {
		this.enemyImgs = enemyImgs;
	}*/

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
		for (int y = 0; y < 2; y++) {
			for (int x = 0; x < 6; x++) {
				enemyImgs.add(atlas.getSubimage(x*Constants.DimSprite, (3 + y)*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite));
			}
		}
		//enemyImgs[3] = atlas.getSubimage(3* Constants.DimSprite, 2*Constants.DimSprite, Constants.DimSprite, Constants.DimSprite);
		// coordinaten van afbeeldingen invullen
	}

	public void update() {
		
		updateWaveManager();
		
		if(isTimeForNewEnemy()) {
			spawnEnemy();
		}
		for (Enemy e : enemies) {
			if (e.getAlive()) {
				e.movement(map);
			}}
		enemies.removeIf(n -> (n.getAlive() == false));
				
	}
	private void updateWaveManager() {
		playing.getWaveManager().update();		
	}

	private boolean isTimeForNewEnemy() {
		if (playing.getWaveManager().isTimeForNewEnemy()){
			if(playing.getWaveManager().isThereMoreEnemies()) {
				return true;
			}
		}
		return false;
	}

	private void spawnEnemy() {
		addEnemy(playing.getWaveManager().getNextEnemy());
		
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
		g.drawImage(enemyImgs.get(Constants.Enemies.GetSprite(e.getEnemyType())), (int) e.getX(), (int) e.getY(), null);
		}
		else if (e.timerhelp == 1 || e.timerhelp == 3) {
		g.drawImage(enemyImgs.get(Constants.Enemies.GetSprite(e.getEnemyType()) + 1), (int) e.getX(), (int) e.getY(), null);
		}
		else if (e.timerhelp == 2) {
		g.drawImage(enemyImgs.get(Constants.Enemies.GetSprite(e.getEnemyType()) + 2), (int) e.getX(), (int) e.getY(), null);
		}
	}

	public void RewardGold(int reward) {
		playing.GoldReward(reward);
	}
	
	public void castledmg(int dmg) {
		playing.Castledmg(dmg);
	}

}
