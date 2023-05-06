package objects;

import managers.EnemyManager;

import static helpz.Constants.Enemies.*;

public class Orc extends Enemy{
	
	public Orc(float x, float y, int ID, EnemyManager em) {		//EnemyManager?
		super(x, y, ORC, em);
		
	}

}
