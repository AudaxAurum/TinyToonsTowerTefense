package tower;

public class Tower {
	
	private int x, y, id, towerType, towerLevel, price, projectile, sprite;
	private int cdTick = 0;
	
	private float defaultDmg;
	private float Dmg;
	
	private float defaultRange;
	private float Range;
	
	private float defaultCooldown;
	
	private boolean animation;
	
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
		setSprite(0);
		
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
	
	public float getCurrentRange() {
		if (towerLevel % 5 == 0) {
			Range = defaultRange + helpz.Constants.Towers.GetRangeUpgradeFactor(towerType)*towerLevel;
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
	public void setDefaultRange() {
		defaultRange = helpz.Constants.Towers.GetDefaultRange(towerType);
		Range = defaultRange;
	}
	
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
	
	public void setAnimation(boolean animation) {
		this.animation = animation;
	}
	
	public boolean getAnimation() {
		return animation;
	}


	public int getPrice() {
		return price;
	}
	public void setProjectile() {
		projectile = helpz.Constants.Towers.GetProjectile(towerType);
	}
	public int GetProjectile() {
		return projectile;
	}
	public void setSprite(int animation) {
		sprite = helpz.Constants.Towers.GetSprite(towerType) + animation;
	}
	public int GetSprite() {
		return sprite;
	}
}
