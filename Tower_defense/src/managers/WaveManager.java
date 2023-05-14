package managers;

import java.util.ArrayList;
import java.util.Arrays;

import events.Wave;

public class WaveManager {
	
	ArrayList<Wave> waves = new ArrayList<>();
	private int enemySpawnTickLimit = 85;
	private int enemySpawnTick = enemySpawnTickLimit;
	private int enemyIndex, waveIndex;
	private int waveTickLimit = 60 * 1;
	private int waveTick = 0;

	
	public WaveManager(int level) {
		spawnWaves(level);
	}
	
	public void update() {
		isWaveTimerOver();
		if(enemySpawnTick < enemySpawnTickLimit) {
			enemySpawnTick++;
		}
		if (waveTick < waveTickLimit) {
			waveTick++;
		}
	}
	public void increaseWaveIndex() {
		waveIndex++;
		waveTick = 0;
	}
	
	public int getNextEnemy() {
		enemySpawnTick = 0;
		return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
	}
	public void spawnWaves(int level) {
		if (level == 0) {
			createNormalWave();
			createNormalWave();
			createSimpleWave();
			createHardWave();
			createNormalWave();
			
		}
	}
	public void createNormalWave() {
		waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(3,3,4,4,4,4,4,5,5,5))));
	}
	
	public void createSimpleWave() {
		waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(4,4,4,4,4,4,4,4,4,4))));
	}
	
	public void createHardWave() {
		waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(3,3,3,3,3,3,5,5,5,5))));
	}

	public ArrayList<Wave> GetWaves(){
		return waves;
	}

	public boolean isTimeForNewEnemy() {
		return enemySpawnTick >= enemySpawnTickLimit;
	}
	public boolean isThereMoreEnemies() {
		return enemyIndex < waves.get(waveIndex).getEnemyList().size();
	}
	public boolean isThereMoreWaves() {
		return waveIndex + 1 < waves.size();
	}
	public void resetEnemyIndex() {
		enemyIndex = 0;
	}

	public boolean isWaveTimerOver() {
		if(enemySpawnTick >= enemySpawnTickLimit) {
			return true;
		}
		return false;
	}
}
