package objects;

import enemy.Enemy;
import tower.Tower;

public class Projectile {
	
	private int projectileType;
	private float x, y, dmg, speed, impactrange;
	private boolean active = true;
	public boolean alive = true;
	private Enemy target;
	
	public Projectile(Tower t,int projectileType, Enemy e) {
		this.x = t.getX();
		this.y = t.getY();
		this.dmg = t.getCurrentDmg();
		this.projectileType = projectileType;
		this.target = e;
		
		setSpeed();
		setImpactRange();
	}
	
	

	public void move() {
		if(Math.abs(x - target.getX()) <= impactrange & Math.abs(y - target.getY()) <= impactrange) { // kan properder
			target.dmg((int)dmg); // dmg aanpassen
			alive = false;
		}    //allemaal voorlopig voor te testen
		else if (x < target.getX()) {
			x += speed;
		}
		else if (x > target.getX()) {
			x -= speed;
		}
		if (y < target.getY()) {
			y += speed;
		}
		else if (y > target.getY()) {
			y -= speed;
		}
	}

	private void setSpeed() {
		speed = helpz.Constants.Projectiles.GetSpeed(projectileType);
		
	}
	private void setImpactRange() {
		impactrange = helpz.Constants.Projectiles.GetImpactRange(projectileType);
		
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
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
