package tower;

public class Archer extends Tower{

	public Archer(int x, int y, int id, int TowerType, int TowerLevel) {
		super(x, y, id, TowerType, TowerLevel);
		setCurrentDmg();
		setCurrentRange();
		setCurrentCooldown();
	}
	public float getCurrentCooldown() {
		return Cooldown;
	}
	public void setCurrentCooldown() {
		if (towerLevel % 10 == 0) {
			Cooldown = defaultCooldown - (float) 0.2*towerLevel;
		}
	}
	public float getCurrentRange() {
		if (towerLevel % 5 == 0) {
			Range = defaultRange + 5*towerLevel;
		}
		return Range;
	}
	public float getCurrentDmg() {
		Dmg = defaultDmg + towerLevel;
		return Dmg;
	}
	public void setCurrentDmg() {
		Dmg = defaultDmg + towerLevel;
	}

}
