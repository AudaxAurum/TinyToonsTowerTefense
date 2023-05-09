package objects;

import java.awt.geom.Point2D;

public class Projectile {
	
	private Point2D.Float position;
	private int ID, projectileType;
	private float x, y, Speed, xgo, ygo;
	private boolean active = true;
	public boolean alive = true;
	
	public Projectile(float x, float y, float Speed, int ID, int projectileType, float xgo, float ygo) {
		position = new Point2D.Float (x,y);
		this.Speed = Speed;
		this.ID = ID;
		this.projectileType = projectileType;
		this.xgo = xgo;
		this.ygo = ygo;
	}
	
	public void move() {
		/*if(x == xgo & y == ygo) {
			alive = false;
		}*/     //allemaal voorlopig voor te testen
		if (x < xgo) {
			x += Speed;
		}
		else if (x > xgo) {
			x -= Speed;
		}
		if (y < ygo) {
			y += Speed;
		}
		else if (y < ygo) {
			y -= Speed;
		}
	}

	public Point2D.Float getPosition() {
		return position;
	}

	public void setPosition(Point2D.Float position) {
		this.position = position;
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
