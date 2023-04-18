package main;

public enum GameStates {

	PLAYING,
	SETTINGS,
	MENU;
	
	public static void SetGameState(GameStates state) {
			gameState= state;
	}
	
	public static GameStates gameState = MENU;
	
}
