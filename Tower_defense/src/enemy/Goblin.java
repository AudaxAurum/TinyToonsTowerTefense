package enemy;

import managers.EnemyManager;

import static helpz.Constants.Enemies.*;

public class Goblin extends Enemy{
	
	public Goblin(float x, float y, int ID, EnemyManager em) {		//EnemyManager?
		super(x, y, ID, GOBLIN);
				
	}

}

