package objects;

import java.awt.geom.Point2D;

public class Projectile {
	
	private Point2D.Float position;
	private int ID, projectileType;
	private boolean active = true;
	
	public Projectile(float x, float y, int ID, int projectileType) {
		position = new Point2D.Float (x,y);
		this.ID = ID;
		this.projectileType = projectileType;
	}
	
	public void move(float x, float y) {
		position.x += x;
		position.y += y;
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
