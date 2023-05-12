package objects;

import java.awt.geom.Point2D;

import enemy.Enemy;
import tower.Tower;

public class Projectile {
	
	private Point2D.Float position;
	private int ID, projectileType;
	private float x, y, dmg, Speed;
	private boolean active = true;
	public boolean alive = true;
	private Enemy target;
	
	public Projectile(Tower t, float Speed, int ID, int projectileType, Enemy e) {
		this.x = t.getX();
		this.y = t.getY();
		this.dmg = t.getCurrentDmg();
		this.Speed = Speed;
		this.ID = ID;
		this.projectileType = projectileType;
		this.target = e;
	}
	
	public void move() {
		if(Math.abs(x - target.getX()) <= 10 & Math.abs(y - target.getY()) <= 10) { // kan properder
			target.dmg((int)dmg); // dmg aanpassen
			alive = false;
		}    //allemaal voorlopig voor te testen
		else if (x < target.getX()) {
			x += Speed;
		}
		else if (x > target.getX()) {
			x -= Speed;
		}
		if (y < target.getY()) {
			y += Speed;
		}
		else if (y > target.getY()) {
			y -= Speed;
		}
	}

	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}

	public int getID() {
		return ID;
	}

	public int getProjectileType() {
		return projectileType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
