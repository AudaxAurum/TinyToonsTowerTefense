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
	private int waveTickLimit = 60 * 5;
	private int waveTick = 0;
	private boolean waveStartTimer, waveTickTimerOver;

	
	public WaveManager(Playing playing) {
		this.playing = playing;
		createNormalWave();
	}
	
	public void update() {
		if(enemySpawnTick < enemySpawnTickLimit) {
			enemySpawnTick++;
		}
		if (waveStartTimer) {
			waveTick++;
			if (waveTick >= waveTickLimit) {
				waveTickTimerOver = true;
			}
		}
	}
	public void increaseWaveIndex() {
		waveIndex++;
		waveTick = 0;
		waveTickTimerOver = false;
		waveStartTimer = false;
	}
	public boolean isWaveTimerOver() {

		return waveTickTimerOver;
	}
	public void startWaveTimer() {
		waveStartTimer = true;
	}
	
	public int getNextEnemy() {
		enemySpawnTick = 0;
		return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
	}
	
	public void createNormalWave() {
		waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(3,3,4,4,4,4,4,5,5,5))));
		waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(4,4,4,4,4,4,4,4,4,4))));
		
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
	public boolean isThereMoreWaves() {
		return waveIndex + 1 < waves.size();
	}
}
