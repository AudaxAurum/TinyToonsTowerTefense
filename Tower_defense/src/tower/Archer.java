package tower;

public class Archer extends Tower{

	public Archer(int x, int y, int id, int TowerType, int TowerLevel) {
		super(x, y, id, TowerType, TowerLevel);
		setDmg();
		setRange();
		setCooldown();
	}

}
