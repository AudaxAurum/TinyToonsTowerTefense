package managers;

import java.util.ArrayList;
import java.util.Arrays;

import events.Wave;
import scenes.Playing;

public class WaveManager {
	
	private Playing playing;
	ArrayList<Wave> waves = new ArrayList<>();
	private int enemySpawnTickLimit = 60;
	private int enemySpawnTick = enemySpawnTickLimit;

	
	public WaveManager(Playing playing) {
		this.playing = playing;
		createWaves();
	}
	
	public void update() {
		if(enemySpawnTick < enemySpawnTickLimit) {
			enemySpawnTick++;
		}
	}
	
	private void createWaves() {
		waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(4,4,4,4,4,5,5,5,3,3))));
		
	}

	public ArrayList<Wave> GetWaves(){
		return waves;
	}

	public boolean isTimeForNewEnemy() {
		// TODO Auto-generated method stub
		return enemySpawnTick >= enemySpawnTickLimit;
	}
}
