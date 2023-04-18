package enemies;

import java.awt.Rectangle;

public class Enemy {
	private float x,y;
	private Rectangle bounds;
	private int health;
	private int enemyType;
	private int Id;
	
	public Enemy(float x, float y, int Id, int enemyType) {
		this.x = x;
		this.y =y;
		this.Id = Id;
		this.enemyType = enemyType;
		bounds = new Rectangle((int) x, (int) y , 32, 32);
		
		
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
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

}
