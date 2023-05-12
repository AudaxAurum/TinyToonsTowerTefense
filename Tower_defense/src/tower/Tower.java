package tower;

public class Tower {
	
	private int x, y, id, towerType, towerLevel, price;
	private int cdTick = 0;
	
	private float defaultDmg;
	private float Dmg;
	
	private float defaultRange;
	private float Range;
	
	private float defaultCooldown;
	private float Cooldown;
	
	private int timer = 0;
	
	public Tower(int x, int y, int id, int TowerType, int TowerLevel) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.towerType = TowerType;
		this.towerLevel = TowerLevel;
		
		setDefaultDmg();
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
	
	
	//instellingen Dmg
	public void setDefaultDmg() {
		defaultDmg = helpz.Constants.Towers.GetStartDmg(towerType);
	}
	
	public void setCurrentDmg() {
		Dmg = defaultDmg + towerLevel;
	}
	
	public float getDefaultDmg() {
		return defaultDmg;
	}
	
	public float getCurrentDmg() {
		return Dmg;
	}
	
	
	
	//instellingen Range
	public void setDefaultRange() {
		defaultRange = helpz.Constants.Towers.GetDefaultRange(towerType);
	}
	
	public void setCurrentRange() {
		if (towerLevel % 5 == 0) {
			Range = defaultRange + 5*towerLevel;
		}
	}
	
	public float getDefaultRange() {
		return defaultRange;
	}
	
	public float getCurrentRange() {
		return Range;
	}
	
	
	
	//instellingen Cooldown/attackspeed
	public void setDefaultCooldown() {
		defaultCooldown = helpz.Constants.Towers.GetDefaultCooldown(towerType);
	}
	
	public void setCurrentCooldown() {
		if (towerLevel % 10 == 0) {
			Cooldown = defaultCooldown - (float) 0.2*towerLevel;
		}
	}
	
	public float getDefaultCooldown() {
		return defaultCooldown;
	}
	
	public float getCurrentCooldown() {
		return Cooldown;
	}
	
	
	
	public void setPrice() {
		price = helpz.Constants.Towers.Getprice(towerType);
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
		return towerType;
	}

	public void setTowerType(int TowerType) {
		towerType = TowerType;
	}
	
	public int getTowerLevel() {
		return towerLevel;
	}

	public void setTowerLevel(int TowerLevel) {
		towerLevel = TowerLevel;
	}


	public int getPrice() {
		return price;
	}
}
