package levels;

import java.util.ArrayList;

import enemy.Enemy;
import scenes.Playing;

public class level1 {
	private ArrayList<Enemy> waves;
	private Playing playing;
	private int[][] map = {
    		//0: gras, 1: rechte baan, 2: bocht, 3: kruispunt, 4: torenplek, 5: poort kasteel
    		{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,4,1,0,0,0,0,5,0,0,0,2,1,2,0},
            {0,2,1,2,0,0,0,0,1,0,0,0,1,4,1,0},
            {0,1,0,0,0,0,0,0,2,1,1,1,3,1,2,0},
            {0,1,0,0,4,0,0,0,0,0,0,0,1,0,0,0},
            {0,1,0,0,2,1,1,1,1,1,1,1,3,1,2,0},
            {0,1,0,4,1,4,0,0,0,0,0,0,1,4,1,0},
            {0,2,1,1,2,0,0,0,0,0,0,0,2,1,2,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    		
    		};
	
	public void Level1(Playing playing) {
		this.playing = playing;
	}
	
}
