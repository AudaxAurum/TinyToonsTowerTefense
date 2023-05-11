package enemy;

import java.awt.Rectangle;

import helpz.Constants;
import managers.EnemyManager;
import scenes.Playing;

public class Enemy {
	private Rectangle bounds;
	private int health, ID, reward, sprite, dmg; //alles van ID is denk ik overbodig
	private int enemyType;// wss is oververving beter verschillen in subclasses 
	
	// algemene variablen voor de movement
	private float x, y;
	private float speed;
	private EnemyMovement enemymovement;
	private EnemyManager enemymanager;
	private boolean alive = true;
	// tot hier algemene variablen voor de movenemnt
	public int timerhelp;
	
	
	public Enemy(int enemyType, EnemyManager enemymanager) {
		this.enemyType = enemyType;
		this.enemymanager = enemymanager;
		bounds = new Rectangle((int) x, (int) y , Constants.DimSprite, Constants.DimSprite);
		
		enemymovement = new EnemyMovement();
		setStartHealth();
		setSpeed();
		setSprite();
		setReward();
		setdmg();
	}
	private void setdmg() {
		health = helpz.Constants.Enemies.GetStartHealth(enemyType);
		
	}
	public void dmg(int dmg) {
		this.health -= dmg;
		if (health <= 0) {
			if (enemymovement.running)	{
				alive = false;
			}
			enemymanager.RewardGold(reward);
		}
	}
	
		public void movement(int[][] map) { //vragen hoe zei dit zouden aanpakken
			if (alive) {
				enemymovement.movement(map, speed, dmg, enemymanager);
				alive = enemymovement.running;
				timerhelp = enemymovement.timerhelp;
				x = enemymovement.getX();
				y = enemymovement.getY();
			}
		}

		
	private void setStartHealth() {
		dmg = helpz.Constants.Enemies.Getdmg(enemyType);
	}
	private void setSpeed() {
		speed = helpz.Constants.Enemies.GetSpeed(enemyType);
	}	
	private void setSprite() {
		sprite = helpz.Constants.Enemies.GetSprite(enemyType);
	}	
	private void setReward() {
		reward = helpz.Constants.Enemies.GetReward(enemyType);
	}	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(int enemyType) {
		this.enemyType = enemyType;
	}

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}
	public boolean getAlive() {
		return alive;
	}
	public int getSprite() {
		return sprite;
	}
	public int getReward() {
		return reward;
	}
	public int getdmg() {
		return dmg;
	}
}
