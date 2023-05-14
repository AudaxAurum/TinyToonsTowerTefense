package tower;

public class Tower {
	
	private int x, y, id, towerType, towerLevel, price, projectile;
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
		setProjectile();
		System.out.println(Range + "/" + defaultRange + "/" + helpz.Constants.Towers.GetRangeUpgradeFactor(towerType) + "/" + towerLevel);
	}
	public void update() {
		timer ++;
	}
	public boolean cooldowncheck(Tower tower) {
		if (timer >= helpz.Constants.Towers.GetDefaultCooldown(tower.getTowerType())) {
			timer = 0;
			return true;
		}
		return false;
	}
	
	
	//instellingen Dmg
	public void setDefaultDmg() {
		defaultDmg = helpz.Constants.Towers.GetStartDmg(towerType);
	}
	public void setDefaultRange() {
		defaultRange = helpz.Constants.Towers.GetDefaultRange(towerType);
	}
	public float getCurrentRange() {
		Range = defaultRange;
		if (towerLevel % 5 == 0) {
			Range = defaultRange + (helpz.Constants.Towers.GetRangeUpgradeFactor(towerType)*towerLevel);
		}
		return Range;
	}
	public float getCurrentDmg() {
		Dmg = defaultDmg + towerLevel*helpz.Constants.Towers.GetDmgUpgradeFactor(towerType);
		return Dmg;
	}
	public void setCurrentDmg() {
		Dmg = defaultDmg + towerLevel*helpz.Constants.Towers.GetDmgUpgradeFactor(towerType);
	}
	
	public float getDefaultDmg() {
		return defaultDmg;
	}
	
	//instellingen Range
	
	
	public void setCurrentRange() {
		if (towerLevel % 5 == 0) {
			Range = defaultRange + 5*towerLevel;
		}
	}
	
	public float getDefaultRange() {
		return defaultRange;
	}
	
	
	
	
	
	//instellingen Cooldown/attackspeed
	public void setDefaultCooldown() {
		defaultCooldown = helpz.Constants.Towers.GetDefaultCooldown(towerType);
	}
	public float getDefaultCooldown() {
		return defaultCooldown;
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
	public void setProjectile() {
		projectile = helpz.Constants.Towers.GetProjectile(towerType);
		System.out.println(projectile);
	}
	public int GetProjectile() {
		return projectile;
	}
}
