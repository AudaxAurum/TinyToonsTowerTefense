package objects;

public class Tower {
	private int x, y, id, TowerType, TowerLevel;
	
	public Tower(int x, int y, int id, int TowerType, int TowerLevel) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.TowerType = TowerType;
		this.TowerLevel = TowerLevel;
		
		
	}
	
	//hier komt nog iets

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTowerType() {
		return TowerType;
	}

	public void setTowerType(int towerType) {
		TowerType = towerType;
	}
	
	public int getTowerLevel() {
		return TowerLevel;
	}

	public void setTowerLevel(int towerLevel) {
		TowerLevel = towerLevel;
	}

}
