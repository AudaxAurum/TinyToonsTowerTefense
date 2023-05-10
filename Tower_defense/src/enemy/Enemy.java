package enemy;

import java.awt.Rectangle;

import helpz.Constants;
import managers.EnemyManager;
import scenes.Playing;

public class Enemy {
	private Rectangle bounds;
	private int health, ID, value, spriteX, spriteY;
	private int enemyType;// wss is oververving beter verschillen in subclasses 
	
	// algemene variablen voor de movement
	private float x, y;
	private float speed;
	private EnemyMovement enemymovement;
	private boolean alive = true;
	// tot hier algemene variablen voor de movenemnt
	public int timerhelp;
	
	
	public Enemy(float x, float y, int ID, int enemyType) {
		this.ID = ID;
		this.enemyType = enemyType;
		bounds = new Rectangle((int) x, (int) y , Constants.DimSprite, Constants.DimSprite);
		
		enemymovement = new EnemyMovement();
		setStartHealth();
		setValue();
		setSpeed();
		setSprite();
	}
	public void dmg(int dmg) {
		this.health -= dmg;
		if (health <= 0) {
			if (enemymovement.running)	{
				alive = false;
			}
			//Playing.gold += value; voor gold generation
		}
	}
	
		public void movement(int[][] map) { //vragen hoe zei dit zouden aanpakken
			if (alive) {
				enemymovement.movement(map, speed);
				alive = enemymovement.running;
				timerhelp = enemymovement.timerhelp;
				x = enemymovement.getX();
				y = enemymovement.getY();
			}
			}

		
	private void setStartHealth() {
		health = helpz.Constants.Enemies.GetStartHealth(enemyType);
	}
	private void setValue() {
		value = helpz.Constants.Enemies.GetReward(enemyType);
	}	
	private void setSpeed() {
		speed = helpz.Constants.Enemies.GetSpeed(enemyType);
	}	
	private void setSprite() {
		spriteX = helpz.Constants.Enemies.GetSpriteX(enemyType);
		spriteY = helpz.Constants.Enemies.GetSpriteY(enemyType);
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
	public int getSpriteX() {
		return spriteX;
	}
	public int getSpriteY() {
		return spriteY;
	}
}
