package managers;

import java.util.ArrayList;
import java.util.Arrays;

import events.Wave;
import scenes.Playing;

public class WaveManager {
	
	private Playing playing;
	ArrayList<Wave> waves = new ArrayList<>();
	private int enemySpawnTickLimit = 85;
	private int enemySpawnTick = enemySpawnTickLimit;
	private int enemyIndex, waveIndex;

	
	public WaveManager(Playing playing) {
		this.playing = playing;
		createNormalWave();
	}
	
	public void update() {
		if(enemySpawnTick < enemySpawnTickLimit) {
			enemySpawnTick++;
		}
	}
	
	public int getNextEnemy() {
		enemySpawnTick = 0;
		return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
	}
	
	private void createNormalWave() {
		waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(3,3,4,4,4,4,4,5,5,5))));
		
	}
	//public void createHardWave() {
	//	waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(3,3,3,3,3,5,5,5,5,5))));
		
	//}

	public ArrayList<Wave> GetWaves(){
		return waves;
	}

	public boolean isTimeForNewEnemy() {
		return enemySpawnTick >= enemySpawnTickLimit;
	}
	public boolean isThereMoreEnemies() {
		return enemyIndex < waves.get(waveIndex).getEnemyList().size();
	}
}
