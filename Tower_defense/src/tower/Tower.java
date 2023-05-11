package tower;

public class Tower {
	
	private int x, y, id, TowerType, TowerLevel, price;
	private int cdTick = 0;
	
	private float defaultDmg;
	private float defaultRange;
	private float defaultCooldown;
	private int timer = 0;
	
	public Tower(int x, int y, int id, int TowerType, int TowerLevel) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.TowerType = TowerType;
		this.TowerLevel = TowerLevel;
		
		setDefaultRange();
		setDefaultCooldown();
		setPrice();
	}
	public void update() {
		timer ++;
	}
	public boolean cooldowncheck() {
		if (timer >= defaultCooldown) {
			timer = 0;
			return true;
		}
		return false;
	}
	public void setDefaultDmg() {
		defaultDmg = helpz.Constants.Towers.GetStartDmg(TowerType);
	}
	
	public void setDefaultRange() {
		defaultRange = helpz.Constants.Towers.GetDefaultRange(TowerType);
	}
	
	public void setDefaultCooldown() {
		defaultCooldown = helpz.Constants.Towers.GetDefaultCooldown(TowerType);
	}
	public void setPrice() {
		price = helpz.Constants.Towers.Getprice(TowerType);
	}
	public boolean isCooldownOver() {
		return cdTick >= defaultCooldown;
	}

	//hier komt nog iets

	public int getId() {
		return id;
	}

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

	public float getDefaultDmg() {
		return defaultDmg;
	}

	public float getDefaultRange() {
		return defaultRange;
	}

	public float getDefaultCooldown() {
		return defaultCooldown;
	}
	public int getPrice() {
		return price;
	}
}
