package enemy;

import managers.EnemyManager;
import static helpz.Constants.Enemies.*;

public class Bomber extends Enemy {

	public Bomber(EnemyManager em) {		//EnemyManager?
		super(BOMBER, em);
		}
}
